def es_primo(n):
    if n <= 1:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def main():
    try:
        n = int(input("Ingresa un número: "))
        print("¿Es primo?", es_primo(n))
    except ValueError:
        print("Ingresa un número válido")

if __name__ == "__main__":
    main()