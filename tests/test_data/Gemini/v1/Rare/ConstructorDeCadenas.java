package Code.Gemini.v1.Rare;

public class ConstructorDeCadenas {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String[] palabras = {"Hola", " ", "Mundo", " ", "desde", " ", "Java"};

        for (String palabra : palabras) {
            sb.append(palabra);
        }

        String resultado = sb.toString();
        System.out.println("La cadena construida es: " + resultado);
    }
}
