package Code.Java.Abacus.v1.Rare;
import java.util.Arrays;

public class Percentil {
    public static void main(String[] args) {
        double[] datos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(datos);
        int percentil = 75;
        int indice = (int) Math.ceil(percentil / 100.0 * datos.length) - 1;
        System.out.println("Percentil " + percentil + ": " + datos[indice]);
    }
}