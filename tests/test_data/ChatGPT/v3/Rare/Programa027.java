package Code.ChatGPT.v3.Rare;

public class Programa027 {
    public static void main(String[] args) {
        String s = "Aprendiendo a programar";
        int c = 0;
        for (int k = 0; k < s.length(); k++) {
            char ch = Character.toLowerCase(s.charAt(k));
            if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') c++;
        }
        System.out.println("Texto: " + s);
        System.out.println("Vocales: " + c);
    }
}
