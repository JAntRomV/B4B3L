import argparse
from java_translator.translator_service import CodeTranslatorService, validate_arguments

def main():
    parser = argparse.ArgumentParser(
        description="Traductor de código Java a Python o JavaScript usando IA (Soporta archivos y carpetas)"
    )
    parser.add_argument("--input", "-i", help="Archivo .java de entrada (Uso individual)")
    parser.add_argument("--batch", "-b", help="Carpeta/Directorio con múltiples archivos .java (Uso en lote)")
    parser.add_argument("--target", "-t", choices=["python", "javascript"], required=True, help="Lenguaje destino")
    parser.add_argument("--output", "-o", help="Archivo de salida (o carpeta de salida si usas --batch)")
    
    args = parser.parse_args()
    validate_arguments(parser, args)

    # Inicializamos el servicio independiente
    translator_service = CodeTranslatorService(target_language=args.target)

    # Main toma la decisión de qué método del servicio ejecutar
    if args.batch:
        translator_service.translate_batch(args.batch, args.output)
    else:
        print(f"Traduciendo a {args.target}...")
        translator_service.translate_file(args.input, args.output)

if __name__ == "__main__":
    main()