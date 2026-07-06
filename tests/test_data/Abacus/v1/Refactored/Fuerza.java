package Code.Java.Abacus.v1.Refactored;

/**
 * Clase Fuerza - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class Fuerza {
    public static void main(String[] args) {
        double masa = 10; // kg
        double aceleracion = 2; // m/s²
        double fuerza = masa * aceleracion;
        System.out.println("Fuerza: " + fuerza + " N");
    }
}