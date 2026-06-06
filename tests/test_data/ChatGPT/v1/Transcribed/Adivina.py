import random

def adivina():
    numero_secreto = random.randint(1, 10)
    try:
        intento = int(input("Adivina el número (entre 1 y 10): "))
        if intento == numero_secreto:
            print("¡Correcto! Adivinaste el número.")
        else:
            print(f"Incorrecto, el número era: {numero_secreto}")
    except ValueError:
        print("Entrada inválida, debe ser un número entero.")

adivina()