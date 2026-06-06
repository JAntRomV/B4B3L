def contar_vocales(palabra):
    contador = 0
    for c in palabra:
        if c in 'aeiou':
            contador += 1
    return contador

palabra = input("Ingresa una palabra: ").lower()
print(f"Vocales: {contar_vocales(palabra)}")