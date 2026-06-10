package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para convertir números decimales a octal.
 */
public class ConversionOctal {

    /**
     * Convierte un número decimal a octal.
     * @param decimal Número decimal
     * @return Representación octal como String
     */
    public static String convertir(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        return Integer.toOctalString(decimal);
    }

    public static void main(String[] args) {
        int numero = 10;
        String octal = convertir(numero);

        System.out.println(String.format("%d en octal es: %s", numero, octal));
    }
}