package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el área de un cuadrado.
 */
public class AreaCuadrado {

    /**
     * Calcula el área de un cuadrado.
     * @param lado Longitud del lado
     * @return El área del cuadrado
     */
    public static double calcular(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("El lado debe ser positivo");
        }
        return lado * lado;
    }

    public static void main(String[] args) {
        double lado = 5;
        double area = calcular(lado);

        System.out.println(String.format("Área del cuadrado: %.2f", area));
    }
}