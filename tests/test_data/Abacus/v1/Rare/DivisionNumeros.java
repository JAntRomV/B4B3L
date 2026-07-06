package Code.Java.Abacus.v1.Rare;

public class DivisionNumeros {
    public static void main(String[] args) {
        double dividendo = 100;
        double divisor = 4;
        if (divisor != 0) {
            double division = dividendo / divisor;
            System.out.println("La división de " + dividendo + " ÷ " + divisor + " = " + division);
        } else {
            System.out.println("Error: No se puede dividir entre cero");
        }
    }
}