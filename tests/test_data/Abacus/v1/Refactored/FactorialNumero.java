package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el factorial de un número.
 */
public class FactorialNumero {

    /**
     * Calcula el factorial de un número de forma iterativa.
     * @param n Número del cual calcular el factorial
     * @return El factorial de n
     * @throws IllegalArgumentException si n es negativo
     */
    public static long calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }

        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        int numero = 5;

        try {
            long resultado = calcularFactorial(numero);
            System.out.println(String.format("El factorial de %d! = %d", numero, resultado));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}