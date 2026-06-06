package Code.Java.Abacus.v1.Rare;

public class MediaGeometrica {
    public static void main(String[] args) {
        double[] datos = {2, 8, 4};
        double producto = 1;
        for (double dato : datos) {
            producto *= dato;
        }
        double mediaGeometrica = Math.pow(producto, 1.0 / datos.length);
        System.out.println("Media geométrica: " + mediaGeometrica);
    }
}