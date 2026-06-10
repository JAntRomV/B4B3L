package Code.Gemini.v1.Rare;

public class QuitarEspacios {
    public static void main(String[] args) {
        String conEspacios = "   Hola Mundo    ";
        String sinEspacios = conEspacios.trim();

        System.out.println("Original: '" + conEspacios + "'");
        System.out.println("Limpio: '" + sinEspacios + "'");
    }
}
