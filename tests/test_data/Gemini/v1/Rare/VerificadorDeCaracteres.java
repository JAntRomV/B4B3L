package Code.Gemini.v1.Rare;

public class VerificadorDeCaracteres {
    public static void main(String[] args) {
        char ch1 = 'A';
        char ch2 = '7';
        char ch3 = ' ';

        System.out.println("'" + ch1 + "' es una letra? " + Character.isLetter(ch1));
        System.out.println("'" + ch2 + "' es un dígito? " + Character.isDigit(ch2));
        System.out.println("'" + ch3 + "' es un espacio en blanco? " + Character.isWhitespace(ch3));
    }
}
