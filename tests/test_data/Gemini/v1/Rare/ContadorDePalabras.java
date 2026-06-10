package Code.Gemini.v1.Rare;

public class ContadorDePalabras {
    public static void main(String[] args) {
        String frase = "Java es un lenguaje de programación muy versátil.";
        String[] palabras = frase.split(" ");

        int cantidadDePalabras = palabras.length;
        System.out.println("La frase tiene " + cantidadDePalabras + " palabras.");
    }
}
