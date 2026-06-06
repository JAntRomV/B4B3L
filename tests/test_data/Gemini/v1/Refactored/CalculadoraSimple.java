package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para usar métodos privados y estáticos,
 * separando cada operación lógica.
 */
public class CalculadoraSimple {

    private static int sumar(int a, int b) {
        return a + b;
    }

    private static int restar(int a, int b) {
        return a - b;
    }

    private static int multiplicar(int a, int b) {
        return a * b;
    }

    private static int dividir(int a, int b) {
        if (b == 0) {
            System.out.println("Error: División por cero no permitida.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        int numero1 = 20;
        int numero2 = 5;

        System.out.println("La suma es: " + sumar(numero1, numero2));
        System.out.println("La resta es: " + restar(numero1, numero2));
        System.out.println("La multiplicación es: " + multiplicar(numero1, numero2));
        System.out.println("La división es: " + dividir(numero1, numero2));
    }
}
