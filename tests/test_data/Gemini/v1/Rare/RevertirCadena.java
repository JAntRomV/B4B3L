package Code.Gemini.v1.Rare;

public class RevertirCadena {
    public static void main(String[] args) {
        String original = "Hola";
        String revertida = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            revertida += original.charAt(i);
        }

        System.out.println("Cadena original: " + original);
        System.out.println("Cadena revertida: " + revertida);
    }
}
