package Code.Java.Abacus.v1.Refactored;

/**
 * Clase VolumenCubo - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class VolumenCubo {
    public static void main(String[] args) {
        double lado = 4;
        double volumen = Math.pow(lado, 3);
        System.out.println("El volumen del cubo es: " + volumen);
    }
}