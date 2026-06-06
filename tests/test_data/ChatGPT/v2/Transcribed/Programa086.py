def calcula_resultado(a, b):
    try:
        resultado = a * b
        return resultado
    except Exception as e:
        print(f"Ocurrió un error: {e}")
        return None

def main():
    a = 86
    b = 88
    resultado = calcula_resultado(a, b)
    if resultado is not None:
        print(f"Resultado: {resultado}")

if __name__ == "__main__":
    main()