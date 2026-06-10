def convertir_a_fahrenheit(celsius):
    return (celsius * 9/5) + 32

def main():
    try:
        celsius = float(input("Ingrese la temperatura en Celsius: "))
        fahrenheit = convertir_a_fahrenheit(celsius)
        print(f"Equivalente en Fahrenheit: {fahrenheit}")
    except ValueError:
        print("La entrada no es un número")

if __name__ == "__main__":
    main()