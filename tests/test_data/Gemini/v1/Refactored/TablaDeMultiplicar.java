package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para encapsular la lógica de impresión en un método
 * y definir el límite de la tabla como una constante.
 */
public class TablaDeMultiplicar {
    
    private static final int LIMITE_TABLA = 10;

    private static void imprimirTablaDe(int numero) {
        System.out.println("Tabla de multiplicar del " + numero + ":");
        for (int i = 1; i <= LIMITE_TABLA; i++) {
            int resultado = numero * i;
            System.out.printf("%d x %d = %d%n", numero, i, resultado);
        }
    }

    public static void main(String[] args) {
        int numeroParaTabla = 7;
        imprimirTablaDe(numeroParaTabla);
    }
}
