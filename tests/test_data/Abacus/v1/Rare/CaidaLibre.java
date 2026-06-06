package Code.Java.Abacus.v1.Rare;

public class CaidaLibre {
    public static void main(String[] args) {
        double gravedad = 9.8; // m/s²
        double tiempo = 3; // s
        double distancia = 0.5 * gravedad * tiempo * tiempo;
        System.out.println("Distancia recorrida: " + distancia + " m");
    }
}