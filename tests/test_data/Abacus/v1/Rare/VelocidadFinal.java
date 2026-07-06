package Code.Java.Abacus.v1.Rare;

public class VelocidadFinal {
    public static void main(String[] args) {
        double velocidadInicial = 10; // m/s
        double aceleracion = 2; // m/s²
        double tiempo = 5; // s
        double velocidadFinal = velocidadInicial + aceleracion * tiempo;
        System.out.println("Velocidad final: " + velocidadFinal + " m/s");
    }
}