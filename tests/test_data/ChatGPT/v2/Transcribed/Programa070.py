def calcular_resultado(a, b):
    try:
        resultado = a * b
        return resultado
    except Exception as e:
        print(f"Ocurrió un error: {e}")

def main():
    a = int(input("Ingresa el primer número: "))
    b = int(input("Ingresa el segundo número: "))
    resultado = calcular_resultado(a, b)
    print(f"Resultado: {resultado}")

if __name__ == "__main__":
    main()