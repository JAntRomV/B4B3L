package Code.Java.Abacus.v1.Refactored;

/**
 * Clase CalculoPropina - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class CalculoPropina {
    public static void main(String[] args) {
        double cuenta = 150;
        double porcentajePropina = 10;
        double propina = cuenta * porcentajePropina / 100;
        double total = cuenta + propina;
        System.out.println("Total a pagar: " + total);
    }
}