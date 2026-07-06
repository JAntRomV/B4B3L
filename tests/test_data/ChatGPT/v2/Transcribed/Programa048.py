def suma_pares_hasta(n):
    suma = 0
    for i in range(1, n + 1):
        if i % 2 == 0:
            suma += i
    return suma

n = 18
print(f"Suma de pares hasta {n}: {suma_pares_hasta(n)}")