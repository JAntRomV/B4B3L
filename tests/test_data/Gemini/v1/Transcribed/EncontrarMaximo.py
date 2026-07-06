def encontrar_maximo_en_array(numeros):
    if numeros is None or len(numeros) == 0:
        return None
    return max(numeros)

def main():
    numeros = [45, 88, 12, 105, 3, 99]
    maximo = encontrar_maximo_en_array(numeros)

    if maximo is not None:
        print(f"El número más grande en el array es: {maximo}")
    else:
        print("El array está vacío.")

if __name__ == "__main__":
    main()