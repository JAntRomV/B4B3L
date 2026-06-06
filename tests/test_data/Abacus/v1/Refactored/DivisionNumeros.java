package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para realizar la división de dos números con validación.
 */
public class DivisionNumeros {

    /**
     * Método que divide dos números con validación de divisor cero.
     * @param dividendo Número a dividir
     * @param divisor Número por el cual dividir
     * @return El cociente de la división
     * @throws ArithmeticException si el divisor es cero
     */
    public static double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return dividendo / divisor;
    }

    public static void main(String[] args) {
        double dividendo = 100;
        double divisor = 4;

        try {
            double resultado = dividir(dividendo, divisor);
            System.out.println(String.format("La división de %.2f ÷ %.2f = %.2f", 
                dividendo, divisor, resultado));
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}