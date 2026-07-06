def cuenta_vocales(palabra):
    contador = 0
    vocales = 'aeiou'
    for c in palabra:
        if c in vocales:
            contador += 1
    return contador

def main():
    palabra = "ejemplo45"
    palabra = palabra.lower()
    print("Vocales: ", cuenta_vocales(palabra))

if __name__ == "__main__":
    main()