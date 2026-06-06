def suma_pares(n):
    suma = 0
    for i in range(1, n + 1):
        if i % 2 == 0:
            suma += i
    return suma

n = 18
suma = suma_pares(n)
print(f"Suma de pares hasta {n}: {suma}")