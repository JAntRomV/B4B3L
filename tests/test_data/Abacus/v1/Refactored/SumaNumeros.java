package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para realizar la suma de dos números enteros.
 * @author Estudiante
 * @version 1.0
 */
public class SumaNumeros {

    /**
     * Método que suma dos números enteros.
     * @param a Primer número
     * @param b Segundo número
     * @return La suma de a y b
     */
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int numero1 = 15;
        int numero2 = 25;
        int resultado = sumar(numero1, numero2);

        System.out.println(String.format("La suma de %d + %d = %d", 
            numero1, numero2, resultado));
    }
}