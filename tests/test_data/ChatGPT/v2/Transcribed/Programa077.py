def cuenta_vocales(palabra):
    contador = 0
    for c in palabra.lower():
        if c in 'aeiou':
            contador += 1
    return contador

def main():
    palabra = "ejemplo77"
    print(f"Vocales: {cuenta_vocales(palabra)}")

if __name__ == "__main__":
    main()