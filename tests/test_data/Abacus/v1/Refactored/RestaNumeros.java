package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para realizar la resta de dos números.
 */
public class RestaNumeros {

    /**
     * Método que resta dos números.
     * @param a Minuendo
     * @param b Sustraendo
     * @return La diferencia entre a y b
     */
    public static double restar(double a, double b) {
        return a - b;
    }

    public static void main(String[] args) {
        double numero1 = 50.5;
        double numero2 = 20.3;
        double resultado = restar(numero1, numero2);

        System.out.println(String.format("La resta de %.2f - %.2f = %.2f", 
            numero1, numero2, resultado));
    }
}