package Code.ChatGPT.v3.Refactored;

public class Programa019 {
private static double area(double r) { return Math.PI * r * r; }
    private static double perimetro(double r) { return 2 * Math.PI * r; }
    public static void main(String[] args) {
        double r = 9.1;
        System.out.println("Radio: " + r);
        System.out.println("Área: " + area(r) + ", Perímetro: " + perimetro(r));
    }
}
