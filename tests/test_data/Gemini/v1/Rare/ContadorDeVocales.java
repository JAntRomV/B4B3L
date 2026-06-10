package Code.Gemini.v1.Rare;

public class ContadorDeVocales {
    public static void main(String[] args) {
        String texto = "Este es un texto de prueba".toLowerCase();
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                contador++;
            }
        }
        System.out.println("El número de vocales es: " + contador);
    }
}
