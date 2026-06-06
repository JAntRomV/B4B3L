package Code.Java.Abacus.v1.Rare;

public class NumeroAleatorio {
    public static void main(String[] args) {
        int min = 1, max = 100;
        int aleatorio = (int)(Math.random() * (max - min + 1)) + min;
        System.out.println("Número aleatorio entre " + min + " y " + max + ": " + aleatorio);
    }
}