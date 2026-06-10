def cuenta_vocales(palabra):
    contador = 0
    for c in palabra:
        if c in 'aeiou':
            contador += 1
    return contador

def main():
    palabra = input("Ingresa una palabra: ").lower()
    print(f"Vocales: {cuenta_vocales(palabra)}")

if __name__ == "__main__":
    main()