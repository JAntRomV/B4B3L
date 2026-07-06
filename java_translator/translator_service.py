import sys
import os
from pathlib import Path
from java_translator.translator import translate_code, build_polyglot_wrapper
from java_translator.validator import validate_java_code
from java_translator.config import SUPPORTED_TARGETS

class CodeTranslatorService:
    """Clase de servicio encargada de la lógica de negocio de la traducción políglota."""

    def __init__(self, target_language: str):
        if target_language not in SUPPORTED_TARGETS:
            raise ValueError(f"Lenguaje no soportado de manera interna: '{target_language}'")
            
        self.target_language = target_language

    def translate_file(self, input_path: str, output_path: str = None) -> bool:
        """Traduce un único archivo envolviéndolo en la infraestructura políglota."""
        try:
            with open(input_path, "r", encoding="utf-8") as f:
                java_code = f.read()
        except FileNotFoundError:
            print(f"Error: no se encontró el archivo '{input_path}'")
            return False

        is_valid, error_msg = validate_java_code(java_code)
        if not is_valid:
            print(f"Error de validación en {input_path}: {error_msg}")
            return False

        # El nombre de la clase interna del Polyglot Wrapper será el nombre del archivo original
        base_name = Path(input_path).stem

        # Llamar a Groq para empaquetar el string concatenado
        result = translate_code(java_code, self.target_language)
        
        # Ensamblar el cascarón híbrido de Java
        polyglot_code = build_polyglot_wrapper(base_name, self.target_language, result["code"])

        if output_path:
            # Respetamos la ruta exacta que ingresó el usuario por el flag -o
            # NOTA: Como la salida es políglota ejecutable por GraalVM, lo ideal es que termine en .java
            with open(output_path, "w", encoding="utf-8") as f:
                f.write(polyglot_code)
            print(f" -> Guardado híbrido en '{output_path}' (Tokens: In={result['tokens']['input']}, Out={result['tokens']['output']})")
        else:
            # Salida directa a la terminal si no se pasa -o
            print(f"\n--- Código Políglota Híbrido de {input_path} ---\n")
            print(polyglot_code)
            print(f"\nTokens usados → entrada: {result['tokens']['input']}, salida: {result['tokens']['output']}")
        
        return True

    def translate_batch(self, batch_dir: str, output_dir: str = None) -> None:
        """Traduce todos los archivos .java de un lote a envoltorios políglotas .java."""
        if not os.path.isdir(batch_dir):
            print(f"Error: '{batch_dir}' no es un directorio válido.")
            sys.exit(1)

        # Si el usuario no especificó carpeta de salida con -o, creamos una por defecto
        if not output_dir:
            folder_suffix = f"Transcribed_{self.target_language.upper()}"
            final_output_dir = os.path.join(batch_dir, f"../{folder_suffix}")
        else:
            final_output_dir = output_dir

        Path(final_output_dir).mkdir(parents=True, exist_ok=True)

        print(f"Iniciando traducción políglota en lote desde: {batch_dir}")
        print(f"Guardando resultados en: {final_output_dir}\n" + "-"*40)

        for archivo in os.listdir(batch_dir):
            if archivo.endswith(".java") and not archivo.startswith("._"):
                ruta_entrada = os.path.join(batch_dir, archivo)
                
                # Para procesamiento por lotes, generamos archivos .java políglotas estructurales
                base_name = Path(archivo).stem
                nombre_salida = f"{base_name}Poliglota.java"
                ruta_salida = os.path.join(final_output_dir, nombre_salida)

                print(f"Procesando: {archivo}...")
                self.translate_file(ruta_entrada, ruta_salida)

        print("-"*40 + "\n¡Traducción en lote políglota completada con éxito!")


def validate_arguments(parser, args):
    """Valida las reglas de negocio de los argumentos de entrada."""
    if not args.input and not args.batch:
        parser.error("Debes especificar un archivo de entrada (--input) o una carpeta (--batch).")
    if args.input and args.batch:
        parser.error("No puedes usar --input y --batch al mismo tiempo. Elige uno.")