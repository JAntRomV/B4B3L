package Code.Java.Abacus.v1.Refactored;

/**
 * Clase EnergiaKinetica - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class EnergiaKinetica {
    public static void main(String[] args) {
        double masa = 10; // kg
        double velocidad = 5; // m/s
        double energia = 0.5 * masa * velocidad * velocidad;
        System.out.println("Energía cinética: " + energia + " J");
    }
}