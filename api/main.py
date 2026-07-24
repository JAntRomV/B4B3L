from fastapi import FastAPI, Depends, File, UploadFile, Query, HTTPException, Header
from fastapi.responses import FileResponse
from fastapi.middleware.cors import CORSMiddleware  # <-- 1. IMPORTAR MIDDLEWARE

# Componentes de arquitectura de la API
from api.schemas import TranslationRequest

# Capa de Servicio descentralizada (Lógica de Negocio)
from api.services import process_single_java_file, process_zip_batch
from java_translator.translator import translate_code, build_polyglot_wrapper

# Dependencia unificada: Ahora genera UN SOLO input limpio en Swagger
async def get_api_key(
    x_api_key: str = Header(None, alias="X-API-Key")
):
    if not x_api_key:
        raise HTTPException(
            status_code=401, 
            detail="Falta credencial de autenticación. Incluya la cabecera 'X-API-Key'."
        )
    return x_api_key

app = FastAPI(
    title="B4B3L - Polyglot & Multi-Provider Standard Translator API",
    version="1.1.0",
    description = """
API del motor **B4B3L** para la traducción avanzada de código Java con soporte multi-proveedor.

### 🌐 Endpoints Disponibles
* **Texto (`/text`):** Traduce cadenas de código Java enviadas en formato JSON.
* **Archivos/Lotes (`/file`):** Traduce archivos individuales `.java` o carpetas completas en lotes mediante archivos `.zip`.

### 🔄 Modos de Operación
* `standard`: Devuelve el código limpio traducido directamente al lenguaje destino (`python` o `javascript`).
* `polyglot`: Devuelve una clase ejecutable Java híbrida estructurada para el entorno **GraalVM Polyglot API**.

⚠️ *Requieres autenticación mediante la cabecera **X-API-Key** (acepta tokens de Groq, OpenAI, Gemini y Anthropic).*
""",
    swagger_ui_parameters={"defaultModelsExpandDepth": -1}
)

# <-- 2. CONFIGURACIÓN DE CORS -->
# Orígenes permitidos: frontend en producción (Vercel) y entorno local de desarrollo
ALLOWED_ORIGINS = [
    "https://b4b3l.vercel.app",   # Frontend en producción
    "http://localhost:5173",       # Frontend en desarrollo (Vite)
    "http://localhost:3000",       # Next.js/React local (por si acaso)
    "http://localhost:8000",       # Swagger UI local
    "http://127.0.0.1:8000",       # IP local alternativa
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=ALLOWED_ORIGINS,
    allow_credentials=True,   
    allow_methods=["*"], 
    allow_headers=["*"],  
)

# TRADUCCIÓN POR TEXTO (JSON)
@app.post("/api/v1/translate/text", tags=["Main"])
async def translate_text_endpoint(
    request: TranslationRequest, 
    api_key: str = Depends(get_api_key)
):
    if request.mode not in ["standard", "polyglot"]:
        raise HTTPException(status_code=400, detail="El parámetro 'mode' debe ser 'standard' o 'polyglot'.")
    
    try:
        # Pasamos api_key y mode dinámicamente al traductor polimórfico
        translation_result = translate_code(request.code, request.target_language, api_key=api_key, mode=request.mode)
        
        if "error" in translation_result:
            raise HTTPException(status_code=400, detail=translation_result["error"])
            
        raw_code = translation_result["code"]
        
        if request.mode == "polyglot":
            final_code = build_polyglot_wrapper("ClaseDinamica", request.target_language, raw_code)
            lang_returned = "java"
        else:
            final_code = raw_code
            lang_returned = request.target_language

        return {
            "status": "success",
            "mode": request.mode,
            "target_language": lang_returned,
            "translated_code": final_code,
            "tokens": translation_result.get("tokens", 0)
        }
    except HTTPException as he:
        raise he
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

# TRADUCCIÓN POR ARCHIVOS (.JAVA O .ZIP)
@app.post("/api/v1/translate/file", tags=["Main"])
async def translate_file_endpoint(
    target_language: str,
    mode: str = Query("standard", pattern="^(standard|polyglot)$"),
    file: UploadFile = File(...),
    api_key: str = Depends(get_api_key)
):
    filename = file.filename

    # --- CASO A: ARCHIVO ÚNICO .JAVA ---
    if filename.endswith(".java"):
        try:
            file_path, out_name, media_type = await process_single_java_file(file, target_language, mode, api_key=api_key)
            return FileResponse(path=file_path, filename=out_name, media_type=media_type)
        except Exception as e:
            raise HTTPException(status_code=500, detail=f"Error traduciendo archivo Java: {str(e)}")

    # --- CASO B: PROCESAMIENTO POR LOTES (.ZIP) ---
    elif filename.endswith(".zip"):
        try:
            zip_out_path = await process_zip_batch(file, target_language, mode, api_key=api_key)
            return FileResponse(
                path=zip_out_path, 
                filename=f"lote_{mode}_{target_language}.zip", 
                media_type="application/zip"
            )
        except HTTPException as he:
            raise he
        except Exception as e:
            raise HTTPException(status_code=500, detail=f"Error en procesamiento por lote: {str(e)}")

    else:
        raise HTTPException(status_code=400, detail="Formato de archivo inválido. Utilice un archivo '.java' o un '.zip'.")