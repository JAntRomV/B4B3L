package Code.Java.Abacus.v1.Rare;

public class VolumenCono {
    public static void main(String[] args) {
        double radio = 3;
        double altura = 5;
        double volumen = (1.0/3.0) * Math.PI * radio * radio * altura;
        System.out.println("Volumen del cono: " + volumen);
    }
}