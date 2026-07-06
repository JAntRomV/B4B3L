palabra = input("Ingresa una palabra: ")
palabra = palabra.lower()
contador = sum(1 for c in palabra if c in 'aeiou')
print(f"Vocales: {contador}")