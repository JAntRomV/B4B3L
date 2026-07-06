package Code.Gemini.v1.Rare;

public class PalabraMasLarga {
    public static void main(String[] args) {
        String frase = "Encuentra la palabra mas larga aqui";
        String[] palabras = frase.split(" ");
        String masLarga = "";

        for (String palabra : palabras) {
            if (palabra.length() > masLarga.length()) {
                masLarga = palabra;
            }
        }
        System.out.println("La palabra más larga es: '" + masLarga + "'");
    }
}
