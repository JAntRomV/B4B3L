package Code.Java.Abacus.v1.Rare;

public class NumeroMayor {
    public static void main(String[] args) {
        int a = 25, b = 40, c = 15;
        int mayor = a;
        if (b > mayor) mayor = b;
        if (c > mayor) mayor = c;
        System.out.println("El número mayor es: " + mayor);
    }
}