def cuenta_vocales(palabra):
    contador = 0
    for c in palabra.lower():
        if c in 'aeiou':
            contador += 1
    return contador

palabra = "ejemplo37"
print("Vocales:", cuenta_vocales(palabra))