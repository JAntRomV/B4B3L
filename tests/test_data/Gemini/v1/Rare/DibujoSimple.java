package Code.Gemini.v1.Rare;

public class DibujoSimple {
    public static void main(String[] args) {
        int lado = 5;

        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
