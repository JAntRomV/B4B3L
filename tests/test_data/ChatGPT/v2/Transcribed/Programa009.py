def contar_vocales(palabra):
    contador = 0
    for c in palabra:
        if c in 'aeiou':
            contador += 1
    return contador

def main():
    palabra = "ejemplo9"
    palabra = palabra.lower()
    print("Vocales:", contar_vocales(palabra))

if __name__ == "__main__":
    main()