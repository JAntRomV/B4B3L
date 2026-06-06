package Code.Gemini.v1.Rare;

public class Interruptor {
    public static void main(String[] args) {
        boolean luzEncendida = false;
        System.out.println("La luz está apagada.");

        luzEncendida = !luzEncendida;
        System.out.println("¡Click! La luz está ahora " + (luzEncendida ? "encendida." : "apagada."));

        luzEncendida = !luzEncendida;
        System.out.println("¡Click! La luz está ahora " + (luzEncendida ? "encendida." : "apagada."));
    }
}
