def suma_pares_hasta(n):
    suma = 0
    for i in range(1, n + 1):
        if i % 2 == 0:
            suma += i
    return suma

n = 10
print(f"Suma de pares hasta {n}: {suma_pares_hasta(n)}")

# o de manera más pitónica
def suma_pares_hasta_pitonica(n):
    return sum(i for i in range(1, n + 1) if i % 2 == 0)

n = 10
print(f"Suma de pares hasta {n}: {suma_pares_hasta_pitonica(n)}")