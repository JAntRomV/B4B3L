package Code.Gemini.v1.Rare;

public class IntercambioDeVariables {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        
        System.out.println("Antes: a = " + a + ", b = " + b);

        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("Después: a = " + a + ", b = " + b);
    }
}
