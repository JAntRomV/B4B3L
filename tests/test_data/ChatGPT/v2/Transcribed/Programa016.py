def suma_pares(n):
    try:
        suma = sum(i for i in range(1, n + 1) if i % 2 == 0)
        return suma
    except Exception as e:
        print(f"Ocurrió un error: {e}")

def main():
    n = 16
    suma = suma_pares(n)
    print(f"Suma de pares hasta {n}: {suma}")

if __name__ == "__main__":
    main()