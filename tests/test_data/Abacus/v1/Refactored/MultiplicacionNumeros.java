package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para realizar la multiplicación de dos números.
 */
public class MultiplicacionNumeros {

    /**
     * Método que multiplica dos números enteros.
     * @param a Primer factor
     * @param b Segundo factor
     * @return El producto de a y b
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        int numero1 = 7;
        int numero2 = 8;
        int resultado = multiplicar(numero1, numero2);

        System.out.println(String.format("La multiplicación de %d × %d = %d", 
            numero1, numero2, resultado));
    }
}