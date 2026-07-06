package Code.Java.Abacus.v1.Rare;

public class ConversionOctal {
    public static void main(String[] args) {
        int numero = 10;
        String octal = Integer.toOctalString(numero);
        System.out.println(numero + " en octal es: " + octal);
    }
}