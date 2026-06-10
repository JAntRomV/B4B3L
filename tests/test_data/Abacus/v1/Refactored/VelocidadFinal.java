package Code.Java.Abacus.v1.Refactored;

/**
 * Clase VelocidadFinal - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class VelocidadFinal {
    public static void main(String[] args) {
        double velocidadInicial = 10; // m/s
        double aceleracion = 2; // m/s²
        double tiempo = 5; // s
        double velocidadFinal = velocidadInicial + aceleracion * tiempo;
        System.out.println("Velocidad final: " + velocidadFinal + " m/s");
    }
}