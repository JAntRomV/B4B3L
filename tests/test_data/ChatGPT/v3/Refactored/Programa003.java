package Code.ChatGPT.v3.Refactored;

public class Programa003 {
private static String serieFibo(int n) {
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 1;
        for (int k = 0; k < n; k++) {
            sb.append(a);
            if (k < n - 1) sb.append(", ");
            int c = a + b;
            a = b; b = c;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println("Fibonacci (" + n + "): " + serieFibo(n));
    }
}
