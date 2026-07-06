package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para verificar si un número es Armstrong.
 */
public class NumeroArmstrong {

    /**
     * Verifica si un número es Armstrong.
     * Un número Armstrong es igual a la suma de sus dígitos elevados al número de dígitos.
     * @param numero Número a verificar
     * @return true si es Armstrong, false en caso contrario
     */
    public static boolean esArmstrong(int numero) {
        if (numero < 0) {
            return false;
        }

        int original = numero;
        int suma = 0;
        int digitos = String.valueOf(numero).length();

        while (numero != 0) {
            int digito = numero % 10;
            suma += Math.pow(digito, digitos);
            numero /= 10;
        }

        return suma == original;
    }

    public static void main(String[] args) {
        int numero = 153;
        boolean resultado = esArmstrong(numero);

        System.out.println(String.format("%d %s Armstrong", numero, resultado ? "es" : "no es"));
    }
}