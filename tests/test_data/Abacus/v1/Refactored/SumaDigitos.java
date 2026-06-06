package Code.Java.Abacus.v1.Refactored;

/**
 * Clase SumaDigitos - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class SumaDigitos {
    public static void main(String[] args) {
        int numero = 12345;
        int suma = 0;
        while (numero != 0) {
            suma += numero % 10;
            numero /= 10;
        }
        System.out.println("La suma de los dígitos es: " + suma);
    }
}