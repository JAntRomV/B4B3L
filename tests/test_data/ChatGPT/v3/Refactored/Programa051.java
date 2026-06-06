package Code.ChatGPT.v3.Refactored;

public class Programa051 {
private static double safeDiv(int x, int y) {
        return y == 0 ? Double.NaN : (double) x / y;
    }
    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        System.out.println("a=" + a + ", b=" + b);
        System.out.println("suma=" + (a + b));
        System.out.println("resta=" + (a - b));
        System.out.println("mult=" + (a * b));
        System.out.println("div=" + safeDiv(a, b));
    }
}
