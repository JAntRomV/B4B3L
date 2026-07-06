def calcular_resultado(a, b):
    return a * b

def main():
    try:
        a = int(input("Ingresa el primer número: "))
        b = int(input("Ingresa el segundo número: "))
        resultado = calcular_resultado(a, b)
        print("Resultado:", resultado)
    except ValueError:
        print("Error: ingresa un número válido")

if __name__ == "__main__":
    main()