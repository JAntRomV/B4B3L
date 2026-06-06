package Code.Java.Abacus.v1.Refactored;

/**
 * Clase LeyOhm - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class LeyOhm {
    public static void main(String[] args) {
        double voltaje = 12; // V
        double resistencia = 4; // Ω
        double corriente = voltaje / resistencia;
        System.out.println("Corriente: " + corriente + " A");
    }
}