package Code.Java.Abacus.v1.Refactored;

/**
 * Clase CalculoDescuento - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class CalculoDescuento {
    public static void main(String[] args) {
        double precioOriginal = 500;
        double descuento = 20; // porcentaje
        double precioFinal = precioOriginal - (precioOriginal * descuento / 100);
        System.out.println("Precio con descuento: " + precioFinal);
    }
}