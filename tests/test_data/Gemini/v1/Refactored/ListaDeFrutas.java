package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para separar la lógica de impresión de la lista.
 * El código original ya era bastante claro.
 */
public class ListaDeFrutas {

    private static void imprimirLista(String[] lista) {
        System.out.println("Contenido de la lista:");
        for (String elemento : lista) {
            System.out.println("- " + elemento);
        }
    }

    public static void main(String[] args) {
        String[] frutas = {"Manzana", "Banana", "Naranja", "Fresa"};
        imprimirLista(frutas);
    }
}
