def suma_multiplos(a, b):
    try:
        resultado = a * b
        return resultado
    except Exception as e:
        print(f"Ocurrió un error: {e}")

def main():
    a = 46
    b = 48
    print("Ingresa el primer número: ")
    # a = int(input()) # si se quiere ingresar el valor desde teclado
    print("Ingresa el segundo número: ")
    # b = int(input()) # si se quiere ingresar el valor desde teclado
    resultado = suma_multiplos(a, b)
    print(f"Resultado: {resultado}")

if __name__ == "__main__":
    main()