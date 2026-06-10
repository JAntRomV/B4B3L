def contar_vocales(palabra):
    vocales = 'aeiou'
    return sum(1 for c in palabra.lower() if c in vocales)

def main():
    palabra = input("Ingresa una palabra: ")
    contador = contar_vocales(palabra)
    print(f"Vocales: {contador}")

if __name__ == "__main__":
    main()