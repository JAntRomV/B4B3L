package Code.Gemini.v1.Rare;

public class TiposDeCasting {
    public static void main(String[] args) {
        int miEntero = 100;
        double miDoble = miEntero;
        System.out.println("Casting implícito: " + miDoble);

        double otroDoble = 123.45;
        int otroEntero = (int) otroDoble;
        System.out.println("Casting explícito: " + otroEntero);
    }
}
