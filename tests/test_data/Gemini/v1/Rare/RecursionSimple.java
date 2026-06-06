package Code.Gemini.v1.Rare;

public class RecursionSimple {

    public static void cuentaRegresiva(int n) {
        if (n <= 0) {
            System.out.println("¡Fin!");
            return;
        }
        System.out.println(n);
        cuentaRegresiva(n - 1);
    }

    public static void main(String[] args) {
        cuentaRegresiva(5);
    }
}
