package Code.Java.Abacus.v1.Refactored;

/**
 * Clase NumeroParImpar - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class NumeroParImpar {
    public static void main(String[] args) {
        int numero = 17;
        if (numero % 2 == 0) {
            System.out.println(numero + " es par");
        } else {
            System.out.println(numero + " es impar");
        }
    }
}