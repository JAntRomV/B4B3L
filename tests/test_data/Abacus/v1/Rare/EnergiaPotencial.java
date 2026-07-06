package Code.Java.Abacus.v1.Rare;

public class EnergiaPotencial {
    public static void main(String[] args) {
        double masa = 10; // kg
        double gravedad = 9.8; // m/s²
        double altura = 5; // m
        double energia = masa * gravedad * altura;
        System.out.println("Energía potencial: " + energia + " J");
    }
}