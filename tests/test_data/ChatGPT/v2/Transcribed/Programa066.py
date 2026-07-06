def calcula_resultado(a, b):
    try:
        resultado = a * b
        return resultado
    except Exception as e:
        print(f"Ocurrió un error: {e}")

def main():
    a = 66
    b = 68
    resultado = calcula_resultado(a, b)
    print(f"Resultado: {resultado}")

if __name__ == "__main__":
    main()