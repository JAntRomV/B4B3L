import sys
import os
from pathlib import Path
from java_translator.translator import translate_code
from java_translator.validator import validate_java_code
from java_translator.config import SUPPORTED_TARGETS

class CodeTranslatorService:
    """Clase de servicio encargada de la lógica de negocio de la traducción."""

    def __init__(self, target_language: str):
        if target_language not in SUPPORTED_TARGETS:
            raise ValueError(f"Lenguaje no soportado de manera interna: '{target_language}'")
            
        self.target_language = target_language
        self.extension = SUPPORTED_TARGETS[target_language]

    def translate_file(self, input_path: str, output_path: str = None) -> bool:
        """Traduce un único archivo de forma aislada."""
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

        result = translate_code(java_code, self.target_language)

        if output_path:
            with open(output_path, "w", encoding="utf-8") as f:
                f.write(result["code"])
            print(f" -> Guardado en '{output_path}' (Tokens: In={result['tokens']['input']}, Out={result['tokens']['output']})")
        else:
            print(f"\n--- Código traducido de {input_path} ---\n")
            print(result["code"])
            print(f"\nTokens usados → entrada: {result['tokens']['input']}, salida: {result['tokens']['output']}")
        
        return True

    def translate_batch(self, batch_dir: str, output_dir: str = None) -> None:
        """Traduce todos los archivos .java dentro de un directorio."""
        if not os.path.isdir(batch_dir):
            print(f"Error: '{batch_dir}' no es un directorio válido.")
            sys.exit(1)

        final_output_dir = output_dir if output_dir else os.path.join(batch_dir, "../Transcribed")
        Path(final_output_dir).mkdir(parents=True, exist_ok=True)

        print(f"Iniciando traducción en lote desde: {batch_dir}")
        print(f"Guardando resultados en: {final_output_dir}\n" + "-"*40)

        for archivo in os.listdir(batch_dir):
            if archivo.endswith(".java") and not archivo.startswith("._"):
                ruta_entrada = os.path.join(batch_dir, archivo)
                nombre_salida = archivo.replace(".java", self.extension)
                ruta_salida = os.path.join(final_output_dir, nombre_salida)

                print(f"Procesando: {archivo}...")
                self.translate_file(ruta_entrada, ruta_salida)

        print("-"*40 + "\n¡Traducción en lote completada con éxito!")


def validate_arguments(parser, args):
    """Valida las reglas de negocio de los argumentos de entrada."""
    if not args.input and not args.batch:
        parser.error("Debes especificar un archivo de entrada (--input) o una carpeta (--batch).")
    if args.input and args.batch:
        parser.error("No puedes usar --input y --batch al mismo tiempo. Elige uno.")