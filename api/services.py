import os
import shutil
import zipfile
from pathlib import Path
from fastapi import UploadFile, HTTPException

# Importamos las herramientas del traductor core
from java_translator.translator import translate_code, build_polyglot_wrapper

TMP_DIR = Path("/tmp/b4b3l_api")
TMP_DIR.mkdir(parents=True, exist_ok=True)

def get_file_extension(target_language: str) -> str:
    """Retorna la extensión adecuada según el lenguaje destino."""
    return ".py" if target_language.lower() == "python" else ".js"


async def process_single_java_file(file: UploadFile, target_language: str, mode: str, api_key: str = None) -> tuple[Path, str, str]:
    """
    Procesa, traduce y empaqueta un único archivo .java.
    Retorna una tupla con: (ruta_del_archivo_temporal, nombre_salida, media_type)
    """
    class_name = Path(file.filename).stem
    content = await file.read()
    
    # CORRECCIÓN: Ahora pasamos la api_key recibida desde el endpoint
    translation_result = translate_code(content.decode("utf-8"), target_language, api_key=api_key)
    raw_code = translation_result["code"]
    
    if mode == "polyglot":
        codigo_final = build_polyglot_wrapper(class_name, target_language, raw_code)
        output_filename = f"{class_name}Poliglota.java"
        media_type = "text/x-java-source"
    else:
        codigo_final = raw_code
        output_filename = f"{class_name}{get_file_extension(target_language)}"
        media_type = "text/plain"
    
    tmp_output_path = TMP_DIR / output_filename
    tmp_output_path.write_text(codigo_final, encoding="utf-8")
    
    return tmp_output_path, output_filename, media_type


async def process_zip_batch(file: UploadFile, target_language: str, mode: str, api_key: str = None) -> Path:
    """
    Descomprime un archivo ZIP, traduce todos los archivos .java internos
    respetando el árbol de directorios y empaqueta el resultado en un nuevo ZIP.
    Retorna la ruta del archivo ZIP resultante.
    """
    upload_id = os.urandom(4).hex()
    extract_dir = TMP_DIR / f"extract_{upload_id}"
    output_dir = TMP_DIR / f"output_{upload_id}"
    extract_dir.mkdir()
    output_dir.mkdir()

    zip_in_path = TMP_DIR / f"{upload_id}_{file.filename}"
    zip_out_path = TMP_DIR / f"resultado_{upload_id}.zip"

    try:
        # Guardar ZIP entrante
        with open(zip_in_path, "wb") as buffer:
            shutil.copyfileobj(file.file, buffer)

        # Extraer contenido
        with zipfile.ZipFile(zip_in_path, 'r') as zip_ref:
            zip_ref.extractall(extract_dir)

        java_files = list(extract_dir.glob("**/*.java"))
        if not java_files:
            raise HTTPException(status_code=400, detail="No hay archivos .java dentro del archivo ZIP provisto.")

        # Procesar lote iterativamente
        for java_file_path in java_files:
            class_name = java_file_path.stem
            java_code = java_file_path.read_text(encoding="utf-8")
            
            # CORRECCIÓN: Pasamos la api_key a cada traducción del lote
            translation_result = translate_code(java_code, target_language, api_key=api_key)
            raw_code = translation_result["code"]
            
            if mode == "polyglot":
                codigo_final = build_polyglot_wrapper(class_name, target_language, raw_code)
                new_name = f"{class_name}Poliglota.java"
            else:
                codigo_final = raw_code
                new_name = f"{class_name}{get_file_extension(target_language)}"
            
            # Replicar la estructura de carpetas original en el output
            relative_path = java_file_path.relative_to(extract_dir)
            out_file_path = (output_dir / relative_path).with_name(new_name)
            out_file_path.parent.mkdir(parents=True, exist_ok=True)
            out_file_path.write_text(codigo_final, encoding="utf-8")

        # Comprimir resultados
        with zipfile.ZipFile(zip_out_path, 'w', zipfile.ZIP_DEFLATED) as zip_out:
            for file_to_zip in output_dir.glob("**/*"):
                if file_to_zip.is_file():
                    zip_out.write(file_to_zip, file_to_zip.relative_to(output_dir))

        return zip_out_path

    finally:
        # Limpieza absoluta de temporales locales de este hilo/petición
        if extract_dir.exists(): shutil.rmtree(extract_dir)
        if output_dir.exists(): shutil.rmtree(output_dir)
        if zip_in_path.exists(): os.remove(zip_in_path)
    """
    Descomprime un archivo ZIP, traduce todos los archivos .java internos
    respetando el árbol de directorios y empaqueta el resultado en un nuevo ZIP.
    Retorna la ruta del archivo ZIP resultante.
    """
    upload_id = os.urandom(4).hex()
    extract_dir = TMP_DIR / f"extract_{upload_id}"
    output_dir = TMP_DIR / f"output_{upload_id}"
    extract_dir.mkdir()
    output_dir.mkdir()

    zip_in_path = TMP_DIR / f"{upload_id}_{file.filename}"
    zip_out_path = TMP_DIR / f"resultado_{upload_id}.zip"

    try:
        # Guardar ZIP entrante
        with open(zip_in_path, "wb") as buffer:
            shutil.copyfileobj(file.file, buffer)

        # Extraer contenido
        with zipfile.ZipFile(zip_in_path, 'r') as zip_ref:
            zip_ref.extractall(extract_dir)

        java_files = list(extract_dir.glob("**/*.java"))
        if not java_files:
            raise HTTPException(status_code=400, detail="No hay archivos .java dentro del archivo ZIP provisto.")

        # Procesar lote iterativamente
        for java_file_path in java_files:
            class_name = java_file_path.stem
            java_code = java_file_path.read_text(encoding="utf-8")
            
            translation_result = translate_code(java_code, target_language)
            raw_code = translation_result["code"]
            
            if mode == "polyglot":
                codigo_final = build_polyglot_wrapper(class_name, target_language, raw_code)
                new_name = f"{class_name}Poliglota.java"
            else:
                codigo_final = raw_code
                new_name = f"{class_name}{get_file_extension(target_language)}"
            
            # Replicar la estructura de carpetas original en el output
            relative_path = java_file_path.relative_to(extract_dir)
            out_file_path = (output_dir / relative_path).with_name(new_name)
            out_file_path.parent.mkdir(parents=True, exist_ok=True)
            out_file_path.write_text(codigo_final, encoding="utf-8")

        # Comprimir resultados
        with zipfile.ZipFile(zip_out_path, 'w', zipfile.ZIP_DEFLATED) as zip_out:
            for file_to_zip in output_dir.glob("**/*"):
                if file_to_zip.is_file():
                    zip_out.write(file_to_zip, file_to_zip.relative_to(output_dir))

        return zip_out_path

    finally:
        # Limpieza absoluta de temporales locales de este hilo/petición
        if extract_dir.exists(): shutil.rmtree(extract_dir)
        if output_dir.exists(): shutil.rmtree(output_dir)
        if zip_in_path.exists(): os.remove(zip_in_path)