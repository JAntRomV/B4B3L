package Code.Java.Abacus.v1.Rare;

public class NumeroMenor {
    public static void main(String[] args) {
        int a = 25, b = 40, c = 15;
        int menor = a;
        if (b < menor) menor = b;
        if (c < menor) menor = c;
        System.out.println("El número menor es: " + menor);
    }
}