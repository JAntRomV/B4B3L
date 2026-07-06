def calcula_resultado():
    a = 30
    b = 32
    resultado = 0
    for _ in range(b):
        resultado += a
    return resultado

def main():
    print("Ingresa el primer número (no se usará): ")
    print("Ingresa el segundo número (no se usará): ")
    resultado = calcula_resultado()
    print("Resultado:", resultado)

if __name__ == "__main__":
    main()