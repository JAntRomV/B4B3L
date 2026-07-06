package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para separar la lógica de obtener el resultado de FizzBuzz
 * de la lógica de imprimirlo, haciendo el código más reutilizable.
 */
public class FizzBuzz {

    private static String obtenerResultadoFizzBuzz(int numero) {
        boolean divisiblePor3 = (numero % 3 == 0);
        boolean divisiblePor5 = (numero % 5 == 0);

        if (divisiblePor3 && divisiblePor5) {
            return "FizzBuzz";
        }
        if (divisiblePor3) {
            return "Fizz";
        }
        if (divisiblePor5) {
            return "Buzz";
        }
        return String.valueOf(numero);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(obtenerResultadoFizzBuzz(i));
        }
    }
}
