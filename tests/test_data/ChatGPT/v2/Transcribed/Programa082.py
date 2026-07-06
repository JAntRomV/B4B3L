def calcular_resultado(a, b):
    resultado = 0
    for _ in range(b):
        resultado += a
    return resultado

def main():
    try:
        a = int(input("Ingresa el primer número: "))
        b = int(input("Ingresa el segundo número: "))
        resultado = calcular_resultado(a, b)
        print(f"Resultado: {resultado}")
    except ValueError:
        print("Error: Ingresa un número válido")

if __name__ == "__main__":
    main()