package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la función tangente.
 */
public class FuncionTangente {

    /**
     * Calcula la tangente de un ángulo.
     * @param anguloGrados Ángulo en grados
     * @return La tangente del ángulo
     */
    public static double calcular(double anguloGrados) {
        double radianes = Math.toRadians(anguloGrados);
        return Math.tan(radianes);
    }

    public static void main(String[] args) {
        double angulo = 45; // grados
        double tangente = calcular(angulo);

        System.out.println(String.format("Tangente de %.0f° = %.4f", angulo, tangente));
    }
}