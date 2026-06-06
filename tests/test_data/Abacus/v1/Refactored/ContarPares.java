package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para contar números pares en un array.
 */
public class ContarPares {

    /**
     * Cuenta la cantidad de números pares en un array.
     * @param numeros Arreglo de números
     * @return Cantidad de números pares
     */
    public static int contar(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo");
        }

        int contador = 0;
        for (int num : numeros) {
            if (num % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int pares = contar(numeros);

        System.out.println("Números pares: " + pares);
    }
}