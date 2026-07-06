package Code.ChatGPT.v3.Refactored;

public class Programa071 {
private static double safeDiv(int x, int y) {
        return y == 0 ? Double.NaN : (double) x / y;
    }
    public static void main(String[] args) {
        int a = 9;
        int b = 3;
        System.out.println("a=" + a + ", b=" + b);
        System.out.println("suma=" + (a + b));
        System.out.println("resta=" + (a - b));
        System.out.println("mult=" + (a * b));
        System.out.println("div=" + safeDiv(a, b));
    }
}
