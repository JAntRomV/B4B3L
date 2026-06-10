package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el área superficial de una esfera.
 */
public class AreaEsfera {

    /**
     * Calcula el área superficial de una esfera.
     * Fórmula: A = 4 * π * r²
     * @param radio Radio de la esfera
     * @return El área superficial de la esfera
     */
    public static double calcular(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser positivo");
        }
        return 4 * Math.PI * radio * radio;
    }

    public static void main(String[] args) {
        double radio = 3;
        double area = calcular(radio);

        System.out.println(String.format("Área de la esfera: %.2f", area));
    }
}