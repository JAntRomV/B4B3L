def cuenta_vocales(palabra):
    return sum(1 for c in palabra if c in 'aeiou')

def main():
    palabra = input("Ingresa una palabra: ").lower()
    print(f"Vocales: {cuenta_vocales(palabra)}")

if __name__ == "__main__":
    main()