package Code.ChatGPT.v3.Refactored;

public class Programa002 {
private static int factorial(int n) {
        int f = 1;
        for (int k = 2; k <= n; k++) f *= k;
        return f;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial de " + n + " = " + factorial(n));
    }
}
