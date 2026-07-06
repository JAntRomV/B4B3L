package Code.ChatGPT.v3.Refactored;

public class Programa014 {
private static boolean esMultiplo(int n, int m) { return n % m == 0; }
    public static void main(String[] args) {
        int n = 43;
        System.out.println(n + (n % 2 == 0 ? " es par" : " es impar"));
        System.out.println("¿Múltiplo de 3? " + esMultiplo(n,3));
        System.out.println("¿Múltiplo de 5? " + esMultiplo(n,5));
    }
}
