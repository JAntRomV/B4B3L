package Code.Gemini.v1.Rare;

public class AdivinaElNumero {
    public static void main(String[] args) {
        int numeroSecreto = 42;
        int intento = 30;

        System.out.println("Intentando adivinar el número secreto...");
        
        if (intento == numeroSecreto) {
            System.out.println("¡Felicidades! Adivinaste el número.");
        } else if (intento < numeroSecreto) {
            System.out.println("El número secreto es mayor.");
        } else {
            System.out.println("El número secreto es menor.");
        }
    }
}
