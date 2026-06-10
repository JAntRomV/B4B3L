package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la función coseno.
 */
public class FuncionCoseno {

    /**
     * Calcula el coseno de un ángulo.
     * @param anguloGrados Ángulo en grados
     * @return El coseno del ángulo
     */
    public static double calcular(double anguloGrados) {
        double radianes = Math.toRadians(anguloGrados);
        return Math.cos(radianes);
    }

    public static void main(String[] args) {
        double angulo = 60; // grados
        double coseno = calcular(angulo);

        System.out.println(String.format("Coseno de %.0f° = %.4f", angulo, coseno));
    }
}