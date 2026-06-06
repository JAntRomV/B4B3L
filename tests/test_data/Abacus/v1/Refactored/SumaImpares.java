package Code.Java.Abacus.v1.Refactored;

/**
 * Clase SumaImpares - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class SumaImpares {
    public static void main(String[] args) {
        int n = 50;
        int suma = 0;
        for (int i = 1; i <= n; i += 2) {
            suma += i;
        }
        System.out.println("La suma de números impares hasta " + n + " es: " + suma);
    }
}