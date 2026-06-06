package Code.ChatGPT.v3.Refactored;

public class Programa077 {
private static int contarVocales(String s) {
        int c = 0;
        for (int k = 0; k < s.length(); k++) {
            char ch = Character.toLowerCase(s.charAt(k));
            if ("aeiou".indexOf(ch) >= 0) c++;
        }
        return c;
    }
    public static void main(String[] args) {
        String s = "Aprendiendo a programar";
        System.out.println("Texto: " + s);
        System.out.println("Vocales: " + contarVocales(s));
    }
}
