package Code.Java.Abacus.v1.Rare;

public class MediaArmonica {
    public static void main(String[] args) {
        double[] datos = {2, 4, 8};
        double suma = 0;
        for (double dato : datos) {
            suma += 1.0 / dato;
        }
        double mediaArmonica = datos.length / suma;
        System.out.println("Media armónica: " + mediaArmonica);
    }
}