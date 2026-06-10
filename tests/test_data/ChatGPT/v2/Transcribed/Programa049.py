def contar_vocales(palabra):
    vocales = 'aeiou'
    contador = sum(1 for c in palabra.lower() if c in vocales)
    return contador

def main():
    palabra = input("Ingresa una palabra: ")
    print("Vocales:", contar_vocales(palabra))

if __name__ == "__main__":
    main()