def calcular_factorial(numero):
    factorial = 1
    for i in range(1, numero + 1):
        factorial *= i
    return factorial

def main():
    try:
        numero = int(input("Ingrese un número: "))
        factorial = calcular_factorial(numero)
        print(f"El factorial de {numero} es: {factorial}")
    except ValueError:
        print("Ingrese un número válido")

if __name__ == "__main__":
    main()