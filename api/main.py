from fastapi import FastAPI, Depends, File, UploadFile, Query, HTTPException
from fastapi.responses import FileResponse

# Componentes de arquitectura de la API
from api.schemas import TranslationRequest
from api.dependencies import verify_groq_api_key

# Capa de Servicio descentralizada (Lógica de Negocio)
from api.services import process_single_java_file, process_zip_batch
from java_translator.translator import translate_code, build_polyglot_wrapper

app = FastAPI(
    title="B4B3L - Polyglot & Standard Translator API",
    version="1.0.0",
    description = """
API del motor **B4B3L** para la traducción avanzada de código Java.

### 🌐 Endpoints Disponibles
* **Texto (`/text`):** Traduce cadenas de código Java enviadas en formato JSON.
* **Archivos/Lotes (`/file`):** Traduce archivos individuales `.java` o carpetas completas en lotes mediante archivos `.zip` (preservando la estructura original).

### 🔄 Modos de Operación
* `standard`: Devuelve el código limpio traducido directamente al lenguaje destino (`python` o `javascript`).
* `polyglot`: Devuelve una clase ejecutable Java híbrida estructurada para el entorno **GraalVM Polyglot API**.

⚠️ *Requiere autenticación mediante la cabecera **X-Groq-API-Key**.*
""",
    swagger_ui_parameters={"defaultModelsExpandDepth": -1}
)

# TRADUCCIÓN POR TEXTO (JSON)
@app.post("/api/v1/translate/text", tags=["Main"])
async def translate_text_endpoint(
    request: TranslationRequest, 
    _apiKey: str = Depends(verify_groq_api_key)
):
    if request.mode not in ["standard", "polyglot"]:
        raise HTTPException(status_code=400, detail="El parámetro 'mode' debe ser 'standard' o 'polyglot'.")
    
    try:
        translation_result = translate_code(request.code, request.target_language)
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
            "tokens": translation_result["tokens"]
        }
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

# TRADUCCIÓN POR ARCHIVOS (.JAVA O .ZIP)
@app.post("/api/v1/translate/file", tags=["Main"])
async def translate_file_endpoint(
    target_language: str,
    mode: str = Query("standard", regex="^(standard|polyglot)$"),
    file: UploadFile = File(...),
    _apiKey: str = Depends(verify_groq_api_key)
):
    filename = file.filename

    # --- CASO A: ARCHIVO ÚNICO .JAVA ---
    if filename.endswith(".java"):
        try:
            file_path, out_name, media_type = await process_single_java_file(file, target_language, mode)
            return FileResponse(path=file_path, filename=out_name, media_type=media_type)
        except Exception as e:
            raise HTTPException(status_code=500, detail=f"Error traduciendo archivo Java: {str(e)}")

    # --- CASO B: PROCESAMIENTO POR LOTES (.ZIP) ---
    elif filename.endswith(".zip"):
        try:
            zip_out_path = await process_zip_batch(file, target_language, mode)
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