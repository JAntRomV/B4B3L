def suma_pares_hasta(n):
    suma = sum(i for i in range(1, n + 1) if i % 2 == 0)
    return suma

def main():
    n = int(input("Ingresa un número: "))
    suma = suma_pares_hasta(n)
    print(f"Suma de pares hasta {n}: {suma}")

if __name__ == "__main__":
    main()