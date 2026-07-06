package Code.Java.Abacus.v1.Rare;
import java.util.Arrays;

public class Mediana {
    public static void main(String[] args) {
        double[] datos = {5, 2, 8, 1, 9, 3, 7};
        Arrays.sort(datos);
        double mediana;
        if (datos.length % 2 == 0) {
            mediana = (datos[datos.length/2 - 1] + datos[datos.length/2]) / 2;
        } else {
            mediana = datos[datos.length/2];
        }
        System.out.println("Mediana: " + mediana);
    }
}