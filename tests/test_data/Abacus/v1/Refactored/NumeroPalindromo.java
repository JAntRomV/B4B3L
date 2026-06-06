package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para verificar si un número es palíndromo.
 */
public class NumeroPalindromo {

    /**
     * Verifica si un número es palíndromo.
     * @param numero Número a verificar
     * @return true si es palíndromo, false en caso contrario
     */
    public static boolean esPalindromo(int numero) {
        int original = Math.abs(numero);
        int invertido = 0;
        int temp = original;

        while (temp != 0) {
            invertido = invertido * 10 + temp % 10;
            temp /= 10;
        }

        return invertido == original;
    }

    public static void main(String[] args) {
        int numero = 12321;
        boolean resultado = esPalindromo(numero);

        System.out.println(String.format("%d %s palíndromo", numero, resultado ? "es" : "no es"));
    }
}