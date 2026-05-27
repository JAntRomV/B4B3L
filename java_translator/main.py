import sys
import argparse
from translator import translate_code
from validator import validate_java_code

def main():
    parser = argparse.ArgumentParser(
        description="Traductor de código Java a Python o JavaScript usando IA"
    )
    parser.add_argument(
        "--input", "-i",
        required=True,
        help="Archivo .java de entrada"
    )
    parser.add_argument(
        "--target", "-t",
        choices=["python", "javascript"],
        required=True,
        help="Lenguaje destino"
    )
    parser.add_argument(
        "--output", "-o",
        help="Archivo de salida (opcional; si no se indica, imprime en consola)"
    )
    
    args = parser.parse_args()

    # Leer el archivo Java
    try:
        with open(args.input, "r", encoding="utf-8") as f:
            java_code = f.read()
    except FileNotFoundError:
        print(f"Error: no se encontró el archivo '{args.input}'")
        sys.exit(1)

    # Validar
    is_valid, error_msg = validate_java_code(java_code)
    if not is_valid:
        print(f"Error de validación: {error_msg}")
        sys.exit(1)

    print(f"Traduciendo a {args.target}...")
    
    # Traducir
    result = translate_code(java_code, args.target)
    
    # Mostrar o guardar
    if args.output:
        with open(args.output, "w", encoding="utf-8") as f:
            f.write(result["code"])
        print(f"Listo. Guardado en '{args.output}'")
    else:
        print("\n--- Código traducido ---\n")
        print(result["code"])
    
    print(f"\nTokens usados → entrada: {result['tokens']['input']}, salida: {result['tokens']['output']}")

if __name__ == "__main__":
    main()