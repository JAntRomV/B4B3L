def cuenta_vocales(palabra: str) -> int:
    """Cuenta el número de vocales en una palabra"""
    return sum(1 for c in palabra.lower() if c in 'aeiou')

def main():
    palabra = input("Ingresa una palabra: ").lower()
    contador = cuenta_vocales(palabra)
    print(f"Vocales: {contador}")

if __name__ == "__main__":
    main()