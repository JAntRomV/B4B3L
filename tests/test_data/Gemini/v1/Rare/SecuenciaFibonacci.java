package Code.Gemini.v1.Rare;

public class SecuenciaFibonacci {
    public static void main(String[] args) {
        int n = 10;
        int t1 = 0, t2 = 1;

        System.out.print("Primeros " + n + " términos: ");
        for (int i = 1; i <= n; ++i) {
            System.out.print(t1 + " ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        System.out.println();
    }
}
