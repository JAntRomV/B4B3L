package Code.Gemini.v1.Rare;

public class DivisionSegura {
    public static void main(String[] args) {
        int dividendo = 10;
        int divisor = 0;

        if (divisor == 0) {
            System.out.println("Error: No se puede dividir por cero.");
        } else {
            int resultado = dividendo / divisor;
            System.out.println("El resultado es: " + resultado);
        }
    }
}
