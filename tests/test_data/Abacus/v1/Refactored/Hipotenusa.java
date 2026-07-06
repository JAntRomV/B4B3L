package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la hipotenusa de un triángulo rectángulo.
 */
public class Hipotenusa {

    /**
     * Calcula la hipotenusa usando el teorema de Pitágoras.
     * Fórmula: c = √(a² + b²)
     * @param cateto1 Primer cateto
     * @param cateto2 Segundo cateto
     * @return La hipotenusa
     */
    public static double calcular(double cateto1, double cateto2) {
        if (cateto1 <= 0 || cateto2 <= 0) {
            throw new IllegalArgumentException("Los catetos deben ser positivos");
        }
        return Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
    }

    public static void main(String[] args) {
        double cateto1 = 3;
        double cateto2 = 4;
        double hipotenusa = calcular(cateto1, cateto2);

        System.out.println(String.format("Hipotenusa: %.2f", hipotenusa));
    }
}