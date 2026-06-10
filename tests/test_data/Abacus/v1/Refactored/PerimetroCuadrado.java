package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el perímetro de un cuadrado.
 */
public class PerimetroCuadrado {

    /**
     * Calcula el perímetro de un cuadrado.
     * @param lado Longitud del lado
     * @return El perímetro del cuadrado
     */
    public static double calcular(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser positivo");
        }
        return 4 * lado;
    }

    public static void main(String[] args) {
        double lado = 5;
        double perimetro = calcular(lado);

        System.out.println(String.format("Perímetro del cuadrado: %.2f", perimetro));
    }
}