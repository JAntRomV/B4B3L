package Code.Gemini.v1.Rare;

public class CalculoMCD {
    public static void main(String[] args) {
        int n1 = 50, n2 = 150;
        int mcd = 1;

        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                mcd = i;
            }
        }
        System.out.printf("El MCD de %d y %d es %d.%n", n1, n2, mcd);
    }
}
