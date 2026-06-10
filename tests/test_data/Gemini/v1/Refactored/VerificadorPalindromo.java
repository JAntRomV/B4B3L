package Code.Gemini.v1.Refactored;

/**
 * Refactorizado a un método booleano que realiza la comprobación.
 * El uso de StringBuilder ya era eficiente.
 */
public class VerificadorPalindromo {

    private static boolean esPalindromo(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        String textoLimpio = texto.toLowerCase().replaceAll("\s+", "");
        String reves = new StringBuilder(textoLimpio).reverse().toString();
        return textoLimpio.equals(reves);
    }

    public static void main(String[] args) {
        String palabra = "reconocer";
        if (esPalindromo(palabra)) {
            System.out.println("'" + palabra + "' es un palíndromo.");
        } else {
            System.out.println("'" + palabra + "' no es un palíndromo.");
        }
    }
}
