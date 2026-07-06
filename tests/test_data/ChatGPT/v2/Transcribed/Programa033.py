def contar_vocales():
    palabra = input("Ingresa una palabra: ").lower()
    contador = sum(1 for c in palabra if c in 'aeiou')
    print("Vocales:", contador)

contar_vocales()