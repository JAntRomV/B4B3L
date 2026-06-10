package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el Mínimo Común Múltiplo.
 */
public class MCM {

    /**
     * Calcula el MCD de dos números.
     * @param a Primer número
     * @param b Segundo número
     * @return El MCD
     */
    private static int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calcula el MCM de dos números.
     * @param a Primer número
     * @param b Segundo número
     * @return El MCM de a y b
     */
    public static int calcular(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        return (a * b) / calcularMCD(a, b);
    }

    public static void main(String[] args) {
        int a = 12, b = 18;
        int mcm = calcular(a, b);

        System.out.println(String.format("MCM de %d y %d: %d", a, b, mcm));
    }
}