package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para convertir números decimales a hexadecimal.
 */
public class ConversionHexadecimal {

    /**
     * Convierte un número decimal a hexadecimal.
     * @param decimal Número decimal
     * @return Representación hexadecimal como String
     */
    public static String convertir(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        return Integer.toHexString(decimal).toUpperCase();
    }

    public static void main(String[] args) {
        int numero = 255;
        String hexadecimal = convertir(numero);

        System.out.println(String.format("%d en hexadecimal es: %s", numero, hexadecimal));
    }
}