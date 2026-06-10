def es_primo(n):
    if n <= 1:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def main():
    n = 69
    print(f"¿Es primo {n}? {es_primo(n)}")

if __name__ == "__main__":
    main()