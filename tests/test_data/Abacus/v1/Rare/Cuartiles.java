package Code.Java.Abacus.v1.Rare;
import java.util.Arrays;

public class Cuartiles {
    public static void main(String[] args) {
        double[] datos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(datos);
        int q1 = datos.length / 4;
        int q2 = datos.length / 2;
        int q3 = 3 * datos.length / 4;
        System.out.println("Q1: " + datos[q1]);
        System.out.println("Q2: " + datos[q2]);
        System.out.println("Q3: " + datos[q3]);
    }
}