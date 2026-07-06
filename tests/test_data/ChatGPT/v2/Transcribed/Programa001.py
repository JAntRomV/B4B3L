def cuenta_vocales(palabra):
    contador = 0
    for c in palabra.lower():
        if c in 'aeiou':
            contador += 1
    return contador

def main():
    palabra = input("Ingresa una palabra: ")
    print("Vocales:", cuenta_vocales(palabra))

if __name__ == "__main__":
    main()