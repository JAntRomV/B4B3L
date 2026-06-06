package Code.Gemini.v1.Rare;

public class ManipulacionDeTexto {
    public static void main(String[] args) {
        String frase = "Java es divertido";

        int longitud = frase.length();
        String enMayusculas = frase.toUpperCase();
        char primerCaracter = frase.charAt(0);

        System.out.println("Frase original: " + frase);
        System.out.println("Longitud de la frase: " + longitud);
        System.out.println("Frase en mayúsculas: " + enMayusculas);
        System.out.println("El primer carácter es: " + primerCaracter);
    }
}
