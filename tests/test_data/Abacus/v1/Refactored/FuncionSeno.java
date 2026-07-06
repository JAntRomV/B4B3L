package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la función seno.
 */
public class FuncionSeno {

    /**
     * Calcula el seno de un ángulo.
     * @param anguloGrados Ángulo en grados
     * @return El seno del ángulo
     */
    public static double calcular(double anguloGrados) {
        double radianes = Math.toRadians(anguloGrados);
        return Math.sin(radianes);
    }

    public static void main(String[] args) {
        double angulo = 30; // grados
        double seno = calcular(angulo);

        System.out.println(String.format("Seno de %.0f° = %.4f", angulo, seno));
    }
}