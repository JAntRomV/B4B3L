package Code.Java.Abacus.v1.Rare;

public class NumeroPalindromo {
    public static void main(String[] args) {
        int numero = 12321;
        int original = numero;
        int invertido = 0;
        while (numero != 0) {
            invertido = invertido * 10 + numero % 10;
            numero /= 10;
        }
        System.out.println(original + (invertido == original ? " es palíndromo" : " no es palíndromo"));
    }
}