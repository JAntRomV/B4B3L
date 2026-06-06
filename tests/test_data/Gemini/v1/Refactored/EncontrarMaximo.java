package Code.Gemini.v1.Refactored;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Refactorizado para usar la API de Streams de Java 8, una forma
 * moderna y funcional de procesar colecciones de datos.
 */
public class EncontrarMaximo {

    private static OptionalInt encontrarMaximoEnArray(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return OptionalInt.empty();
        }
        return Arrays.stream(numeros).max();
    }

    public static void main(String[] args) {
        int[] numeros = {45, 88, 12, 105, 3, 99};
        
        OptionalInt maximo = encontrarMaximoEnArray(numeros);
        
        maximo.ifPresentOrElse(
            max -> System.out.println("El número más grande en el array es: " + max),
            () -> System.out.println("El array está vacío.")
        );
    }
}
