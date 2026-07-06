package Code.Java.Abacus.v1.Refactored;

/**
 * Clase ValorAbsoluto - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class ValorAbsoluto {
    public static void main(String[] args) {
        int numero = -42;
        int valorAbsoluto = Math.abs(numero);
        System.out.println("El valor absoluto de " + numero + " es: " + valorAbsoluto);
    }
}