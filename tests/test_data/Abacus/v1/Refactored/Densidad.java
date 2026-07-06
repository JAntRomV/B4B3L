package Code.Java.Abacus.v1.Refactored;

/**
 * Clase Densidad - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class Densidad {
    public static void main(String[] args) {
        double masa = 100; // kg
        double volumen = 50; // m³
        double densidad = masa / volumen;
        System.out.println("Densidad: " + densidad + " kg/m³");
    }
}