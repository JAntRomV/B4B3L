package Code.Java.Abacus.v1.Rare;

public class CalculosCirculo {
    public static void main(String[] args) {
        double radio = 5.0;
        double pi = 3.14159;
        double area = pi * radio * radio;
        double perimetro = 2 * pi * radio;
        System.out.println("Área del círculo: " + area);
        System.out.println("Perímetro del círculo: " + perimetro);
    }
}