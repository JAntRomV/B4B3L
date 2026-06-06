package Code.Java.Abacus.v1.Refactored;

/**
 * Clase NumeroPositivoNegativo - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class NumeroPositivoNegativo {
    public static void main(String[] args) {
        int numero = -5;
        if (numero > 0) {
            System.out.println(numero + " es positivo");
        } else if (numero < 0) {
            System.out.println(numero + " es negativo");
        } else {
            System.out.println("El número es cero");
        }
    }
}