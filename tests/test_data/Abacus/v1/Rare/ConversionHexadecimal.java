package Code.Java.Abacus.v1.Rare;

public class ConversionHexadecimal {
    public static void main(String[] args) {
        int numero = 255;
        String hexadecimal = Integer.toHexString(numero);
        System.out.println(numero + " en hexadecimal es: " + hexadecimal);
    }
}