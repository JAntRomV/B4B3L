package Code.Java.Abacus.v1.Rare;

public class InteresCompuesto {
    public static void main(String[] args) {
        double capital = 1000;
        double tasa = 0.05;
        int tiempo = 2;
        double monto = capital * Math.pow(1 + tasa, tiempo);
        System.out.println("Monto final: " + monto);
    }
}