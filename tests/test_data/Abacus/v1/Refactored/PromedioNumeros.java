package Code.Java.Abacus.v1.Refactored;

/**
 * Clase PromedioNumeros - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class PromedioNumeros {
    public static void main(String[] args) {
        double[] numeros = {8.5, 9.0, 7.5, 10.0, 6.5};
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        double promedio = suma / numeros.length;
        System.out.println("El promedio es: " + promedio);
    }
}