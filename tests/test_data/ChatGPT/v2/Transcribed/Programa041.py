def cuenta_vocales(palabra):
    contador = 0
    for c in palabra:
        if c in 'aeiou':
            contador += 1
    return contador

palabra = input("Ingresa una palabra: ")
palabra = palabra.lower()
vocales = cuenta_vocales(palabra)
print(f"Vocales: {vocales}")