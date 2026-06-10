package Code.Java.Abacus.v1.Refactored;

/**
 * Clase NumerosPrimos - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class NumerosPrimos {
    public static void main(String[] args) {
        int limite = 50;
        System.out.println("Números primos hasta " + limite + ":");
        for (int num = 2; num <= limite; num++) {
            boolean esPrimo = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) System.out.print(num + " ");
        }
    }
}