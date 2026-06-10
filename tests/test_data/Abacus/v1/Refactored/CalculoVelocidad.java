package Code.Java.Abacus.v1.Refactored;

/**
 * Clase CalculoVelocidad - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class CalculoVelocidad {
    public static void main(String[] args) {
        double distancia = 150;
        double tiempo = 2.5;
        double velocidad = distancia / tiempo;
        System.out.println("Velocidad promedio: " + velocidad + " km/h");
    }
}