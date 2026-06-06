package Code.Gemini.v1.Rare;

public class ConversionStringInt {
    public static void main(String[] args) {
        String numeroEnTexto = "123";
        int numeroReal = Integer.parseInt(numeroEnTexto);
        System.out.println("Número convertido a int: " + (numeroReal + 1));

        int otroNumero = 456;
        String otroTexto = String.valueOf(otroNumero);
        System.out.println("Número convertido a String: " + (otroTexto + "1"));
    }
}
