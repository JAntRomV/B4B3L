def suma_pares_hasta_n():
    n = 12
    suma = sum(i for i in range(1, n + 1) if i % 2 == 0)
    print(f"Suma de pares hasta {n}: {suma}")

print("Ingresa un número: ")
suma_pares_hasta_n()