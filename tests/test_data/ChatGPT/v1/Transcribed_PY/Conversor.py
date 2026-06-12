def obtener_temperatura():
    try:
        celsius = float(input("Ingrese la temperatura en Celsius: "))
        fahrenheit = (celsius * 9/5) + 32
        print(f"Equivalente en Fahrenheit: {fahrenheit}")
    except ValueError:
        print("Ingrese un valor numérico válido")

obtener_temperatura()