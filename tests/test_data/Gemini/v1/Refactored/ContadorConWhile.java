package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para mover la lógica de conteo a un método dedicado.
 */
public class ContadorConWhile {

    private static void contarHasta(int limite) {
        int contador = 1;
        System.out.println("Iniciando conteo...");
        while (contador <= limite) {
            System.out.println("Número: " + contador);
            contador++;
        }
        System.out.println("Conteo finalizado.");
    }

    public static void main(String[] args) {
        contarHasta(5);
    }
}
