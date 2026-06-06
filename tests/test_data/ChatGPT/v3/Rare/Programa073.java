package Code.ChatGPT.v3.Rare;

public class Programa073 {
    public static void main(String[] args) {
        int n = 6;
        int a = 0, b = 1;
        System.out.print("Fibonacci (" + n + "): ");
        for (int k = 0; k < n; k++) {
            System.out.print(a + (k < n-1 ? ", " : "\n"));
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
