package Code.Gemini.v1.Rare;

public class ComparadorDeStrings {
    public static void main(String[] args) {
        String str1 = new String("Java");
        String str2 = new String("Java");

        System.out.println("Usando '==': " + (str1 == str2));
        System.out.println("Usando '.equals()': " + str1.equals(str2));
    }
}
