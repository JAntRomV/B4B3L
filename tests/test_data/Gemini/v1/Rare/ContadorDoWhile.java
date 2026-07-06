package Code.Gemini.v1.Rare;

public class ContadorDoWhile {
    public static void main(String[] args) {
        int i = 10;

        System.out.println("Este bucle se ejecutará al menos una vez.");
        
        do {
            System.out.println("Valor de i: " + i);
            i++;
        } while (i < 5);
        
        System.out.println("Bucle terminado. El valor final de i es " + i);
    }
}
