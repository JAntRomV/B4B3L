package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el volumen de una esfera.
 */
public class VolumenEsfera {

    /**
     * Calcula el volumen de una esfera.
     * Fórmula: V = (4/3) * π * r³
     * @param radio Radio de la esfera
     * @return El volumen de la esfera
     */
    public static double calcular(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser positivo");
        }
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    public static void main(String[] args) {
        double radio = 3;
        double volumen = calcular(radio);

        System.out.println(String.format("Volumen de la esfera: %.2f", volumen));
    }
}