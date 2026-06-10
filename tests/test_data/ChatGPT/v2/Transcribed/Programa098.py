def programa_098():
    a = 98
    b = 100
    resultado = 0
    for _ in range(b):
        resultado += a
    print(f"Resultado: {resultado}")

def main():
    print("Ingresa el primer número: ")
    print("Ingresa el segundo número: ")
    programa_098()

if __name__ == "__main__":
    main()