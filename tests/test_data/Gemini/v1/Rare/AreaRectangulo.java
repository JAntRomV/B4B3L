package Code.Gemini.v1.Rare;

public class AreaRectangulo {

    public static void main(String[] args) {
        double base = 10.5;
        double altura = 5.2;
        
        double area = calcularArea(base, altura);
        
        System.out.println("El área del rectángulo es: " + area);
    }
    
    public static double calcularArea(double b, double h) {
        return b * h;
    }
}
