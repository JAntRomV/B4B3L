package Code.Java.Abacus.v1.Refactored;

/**
 * Clase SumaPrimeroN - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class SumaPrimeroN {
    public static void main(String[] args) {
        int n = 100;
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        System.out.println("La suma de los primeros " + n + " números es: " + suma);
    }
}