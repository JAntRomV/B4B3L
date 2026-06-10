package Code.Java.Abacus.v1.Rare;

public class InvertirNumero {
    public static void main(String[] args) {
        int numero = 12345;
        int invertido = 0;
        while (numero != 0) {
            invertido = invertido * 10 + numero % 10;
            numero /= 10;
        }
        System.out.println("Número invertido: " + invertido);
    }
}