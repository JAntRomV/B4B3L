package Code.Java.Abacus.v1.Refactored;

/**
 * Clase Potencia - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class Potencia {
    public static void main(String[] args) {
        double trabajo = 500; // J
        double tiempo = 10; // s
        double potencia = trabajo / tiempo;
        System.out.println("Potencia: " + potencia + " W");
    }
}