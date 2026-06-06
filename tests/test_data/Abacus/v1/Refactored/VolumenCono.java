package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el volumen de un cono.
 */
public class VolumenCono {

    /**
     * Calcula el volumen de un cono.
     * Fórmula: V = (1/3) * π * r² * h
     * @param radio Radio de la base
     * @param altura Altura del cono
     * @return El volumen del cono
     */
    public static double calcular(double radio, double altura) {
        if (radio <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Radio y altura deben ser positivos");
        }
        return (1.0 / 3.0) * Math.PI * radio * radio * altura;
    }

    public static void main(String[] args) {
        double radio = 3;
        double altura = 5;
        double volumen = calcular(radio, altura);

        System.out.println(String.format("Volumen del cono: %.2f", volumen));
    }
}