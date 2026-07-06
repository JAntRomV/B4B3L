package Code.Java.Abacus.v1.Rare;

public class SerieFibonacci {
    public static void main(String[] args) {
        int n = 10;
        int a = 0, b = 1;
        System.out.print("Serie Fibonacci: " + a + " " + b);
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
    }
}