package Code.Gemini.v1.Rare;

public class SaltarIteracion {
    public static void main(String[] args) {
        System.out.println("Imprimiendo solo números impares del 1 al 10:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
