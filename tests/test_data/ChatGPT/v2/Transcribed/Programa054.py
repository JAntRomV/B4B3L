def calcular_resultado(a, b):
    return a * b

def main():
    try:
        a = int(input("Ingresa el primer número: "))
        b = int(input("Ingresa el segundo número: "))
        resultado = calcular_resultado(a, b)
        print(f"Resultado: {resultado}")
    except ValueError:
        print("Ingrese valores numéricos")

if __name__ == "__main__":
    main()