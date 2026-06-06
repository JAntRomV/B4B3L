def contar_vocales(palabra):
    """Cuenta el número de vocales en una palabra"""
    contador = 0
    for c in palabra.lower():
        if c in 'aeiou':
            contador += 1
    return contador

def main():
    palabra = input("Ingresa una palabra: ").lower()
    print("Vocales:", contar_vocales(palabra))

if __name__ == "__main__":
    main()