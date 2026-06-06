import sys
import os
import argparse
from pathlib import Path
from translator import translate_code
from validator import validate_java_code

def process_single_file(input_path, target, output_path=None):
    """Procesa y traduce un único archivo Java."""
    try:
        with open(input_path, "r", encoding="utf-8") as f:
            java_code = f.read()
    except FileNotFoundError:
        print(f"Error: no se encontró el archivo '{input_path}'")
        return False

    # Validar
    is_valid, error_msg = validate_java_code(java_code)
    if not is_valid:
        print(f"Error de validación en {input_path}: {error_msg}")
        return False

    # Traducir
    result = translate_code(java_code, target)
    
    # Mostrar o guardar
    if output_path:
        with open(output_path, "w", encoding="utf-8") as f:
            f.write(result["code"])
        print(f" -> Guardado en '{output_path}' (Tokens: In={result['tokens']['input']}, Out={result['tokens']['output']})")
    else:
        print(f"\n--- Código traducido de {input_path} ---\n")
        print(result["code"])
        print(f"\nTokens usados → entrada: {result['tokens']['input']}, salida: {result['tokens']['output']}")
    
    return True

def main():
    parser = argparse.ArgumentParser(
        description="Traductor de código Java a Python o JavaScript usando IA (Soporta archivos y carpetas)"
    )
    # Quitamos required=True de --input para poder usar --batch en su lugar
    parser.add_argument(
        "--input", "-i",
        help="Archivo .java de entrada (Uso individual)"
    )
    parser.add_argument(
        "--batch", "-b",
        help="Carpeta/Directorio con múltiples archivos .java (Uso en lote)"
    )
    parser.add_argument(
        "--target", "-t",
        choices=["python", "javascript"],
        required=True,
        help="Lenguaje destino"
    )
    parser.add_argument(
        "--output", "-o",
        help="Archivo de salida (o carpeta de salida si usas --batch)"
    )
    
    args = parser.parse_args()

    # Validación de argumentos: Exigir o --input o --batch, pero no ambos ni ninguno
    if not args.input and not args.batch:
        parser.error("Debes especificar un archivo de entrada (--input) o una carpeta (--batch).")
    if args.input and args.batch:
        parser.error("No puedes usar --input y --batch al mismo tiempo. Elige uno.")

    # --- MODO 1: PROCESAMIENTO EN LOTE (--batch) ---
    if args.batch:
        if not os.path.isdir(args.batch):
            print(f"Error: '{args.batch}' no es un directorio válido.")
            sys.exit(1)
            
        # Si no especifican --output en lote, creamos una carpeta por defecto
        output_dir = args.output if args.output else os.path.join(args.batch, "../Transcribed")
        Path(output_dir).mkdir(parents=True, exist_ok=True)
        
        print(f"Iniciando traducción en lote desde: {args.batch}")
        print(f"Guardando resultados en: {output_dir}\n" + "-"*40)

        # Extensión del archivo de salida
        ext = ".py" if args.target == "python" else ".js"
        
        # Leer la carpeta
        for archivo in os.listdir(args.batch):
            # Filtro de seguridad: Solo archivos .java reales, ignorar basura de Mac (._)
            if archivo.endswith(".java") and not archivo.startswith("._"):
                ruta_archivo_entrada = os.path.join(args.batch, archivo)
                
                # Generar el nombre de salida (ej. Suma.java -> Suma.py)
                nombre_salida = archivo.replace(".java", ext)
                ruta_archivo_salida = os.path.join(output_dir, nombre_salida)
                
                print(f"Procesando: {archivo}...")
                process_single_file(ruta_archivo_entrada, args.target, ruta_archivo_salida)
                
        print("-"*40 + "\n¡Traducción en lote completada con éxito!")

    # --- MODO 2: PROCESAMIENTO INDIVIDUAL (--input) ---
    else:
        print(f"Traduciendo a {args.target}...")
        process_single_file(args.input, args.target, args.output)

if __name__ == "__main__":
    main()