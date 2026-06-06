package Code.Gemini.v1.Rare;

public class SumaSobrecargada {
    
    public static int sumar(int a, int b) {
        System.out.println("Usando la suma de enteros.");
        return a + b;
    }

    public static double sumar(double a, double b) {
        System.out.println("Usando la suma de dobles.");
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Resultado 1: " + sumar(5, 10));
        System.out.println("Resultado 2: " + sumar(3.5, 7.2));
    }
}
