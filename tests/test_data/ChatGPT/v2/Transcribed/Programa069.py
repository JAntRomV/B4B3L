def contar_vocales(palabra):
    vocales = 'aeiou'
    contador = sum(1 for c in palabra if c in vocales)
    return contador

def main():
    palabra = input("Ingresa una palabra: ").lower()
    contador = contar_vocales(palabra)
    print(f"Vocales: {contador}")

if __name__ == "__main__":
    main()