package Code.Gemini.v1.Rare;

public class CalculoFactorial {
    public static void main(String[] args) {
        int numero = 5;
        long factorial = 1;

        for (int i = 1; i <= numero; ++i) {
            factorial *= i;
        }

        System.out.printf("El factorial de %d es %d%n", numero, factorial);
    }
}
