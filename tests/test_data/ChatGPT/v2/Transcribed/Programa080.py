def calcular_suma_pares(n):
    suma = 0
    for i in range(1, n + 1):
        if i % 2 == 0:
            suma += i
    return suma

def main():
    n = 10
    suma_pares = calcular_suma_pares(n)
    print(f"Suma de pares hasta {n}: {suma_pares}")

if __name__ == "__main__":
    main()