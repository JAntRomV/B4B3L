def calcular_factorial(numero):
    factorial = 1
    for i in range(1, numero + 1):
        factorial *= i
    return factorial

def main():
    try:
        numero = int(input("Ingrese un número: "))
        print(f"El factorial de {numero} es: {calcular_factorial(numero)}")
    except ValueError:
        print("Por favor, ingrese un número válido")

if __name__ == "__main__":
    main()