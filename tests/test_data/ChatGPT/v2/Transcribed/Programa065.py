def cuenta_vocales(palabra):
    contador = 0
    for c in palabra:
        if c in 'aeiou':
            contador += 1
    return contador

def main():
    palabra = input("Ingresa una palabra: ").lower()
    contador = cuenta_vocales(palabra)
    print(f"Vocales: {contador}")

if __name__ == "__main__":
    main()