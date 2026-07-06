package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el Máximo Común Divisor usando el algoritmo de Euclides.
 */
public class MCDEuclides {

    /**
     * Calcula el MCD de dos números usando el algoritmo de Euclides.
     * @param a Primer número
     * @param b Segundo número
     * @return El MCD de a y b
     */
    public static int calcular(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 48, b = 18;
        int mcd = calcular(a, b);

        System.out.println(String.format("MCD de %d y %d: %d", a, b, mcd));
    }
}