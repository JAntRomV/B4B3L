def suma_numeros():
    try:
        num1 = int(input("Ingrese el primer número: "))
        num2 = int(input("Ingrese el segundo número: "))
        suma = num1 + num2
        print(f"La suma es: {suma}")
    except ValueError:
        print("Error: Por favor ingrese un número válido")

suma_numeros()

if __name__ == "__main__":
    suma_numeros()