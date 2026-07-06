package Code.Gemini.v1.Rare;

public class LogicaXOR {
    public static void main(String[] args) {
        boolean tieneLlaveA = true;
        boolean tieneLlaveB = false;

        if (tieneLlaveA ^ tieneLlaveB) {
            System.out.println("La puerta se abre.");
        } else {
            System.out.println("La puerta permanece cerrada.");
        }
    }
}
