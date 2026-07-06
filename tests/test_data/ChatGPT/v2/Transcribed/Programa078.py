def calcula_multiplicacion(a, b):
    return a * b

def main():
    try:
        a = int(input("Ingresa el primer número: "))
        b = int(input("Ingresa el segundo número: "))
        resultado = calcula_multiplicacion(a, b)
        print("Resultado:", resultado)
    except ValueError:
        print("Error: Debe ingresar números enteros.")

if __name__ == "__main__":
    main()