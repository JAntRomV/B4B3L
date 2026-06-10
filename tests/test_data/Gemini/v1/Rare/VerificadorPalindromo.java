package Code.Gemini.v1.Rare;

public class VerificadorPalindromo {
    public static void main(String[] args) {
        String palabra = "reconocer";
        String reves = new StringBuilder(palabra).reverse().toString();

        if (palabra.equals(reves)) {
            System.out.println(palabra + " es un palíndromo.");
        } else {
            System.out.println(palabra + " no es un palíndromo.");
        }
    }
}
