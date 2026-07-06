package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para buscar un elemento en un array.
 */
public class BuscarElemento {

    /**
     * Busca un elemento en un array.
     * @param numeros Arreglo de números
     * @param objetivo Elemento a buscar
     * @return El índice del elemento, o -1 si no se encuentra
     */
    public static int buscar(int[] numeros, int objetivo) {
        if (numeros == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo");
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 10, 15, 20, 25};
        int buscar = 15;

        int indice = buscar(numeros, buscar);

        if (indice != -1) {
            System.out.println(buscar + " encontrado en el índice " + indice);
        } else {
            System.out.println(buscar + " no encontrado");
        }
    }
}