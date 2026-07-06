package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para convertir números decimales a binario.
 */
public class ConversionBinario {

    /**
     * Convierte un número decimal a binario.
     * @param decimal Número decimal
     * @return Representación binaria como String
     */
    public static String convertir(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        return Integer.toBinaryString(decimal);
    }

    /**
     * Convierte manualmente (sin usar métodos de Java).
     * @param decimal Número decimal
     * @return Representación binaria como String
     */
    public static String convertirManual(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binario = new StringBuilder();
        int temp = Math.abs(decimal);

        while (temp > 0) {
            binario.insert(0, temp % 2);
            temp /= 2;
        }

        return decimal < 0 ? "-" + binario.toString() : binario.toString();
    }

    public static void main(String[] args) {
        int numero = 10;
        String binario = convertir(numero);

        System.out.println(String.format("%d en binario es: %s", numero, binario));
    }
}