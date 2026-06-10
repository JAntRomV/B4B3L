package Code.Gemini.v1.Rare;

public class LogicaShortCircuit {
    
    public static boolean segundoMetodo() {
        System.out.println("El segundo método fue llamado.");
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Probando AND:");
        if (false && segundoMetodo()) {
            // No entra aquí y segundoMetodo() no se ejecuta
        }

        System.out.println("\nProbando OR:");
        if (true || segundoMetodo()) {
            // Entra aquí, y segundoMetodo() no se ejecuta
        }
    }
}
