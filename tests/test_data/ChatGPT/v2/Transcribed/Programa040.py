def suma_pares(n):
    suma = 0
    for i in range(1, n + 1):
        if i % 2 == 0:
            suma += i
    return suma

def main():
    n = int(input("Ingresa un número: "))
    resultado = suma_pares(n)
    print(f"Suma de pares hasta {n}: {resultado}")

if __name__ == "__main__":
    main()