def calcula_resultado():
    a = int(input("Ingresa el primer número: "))
    b = int(input("Ingresa el segundo número: "))
    resultado = 0
    for _ in range(b):
        resultado += a
    print(f"Resultado: {resultado}")

calcula_resultado()