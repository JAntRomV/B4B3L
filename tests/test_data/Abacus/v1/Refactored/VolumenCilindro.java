package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el volumen de un cilindro.
 */
public class VolumenCilindro {

    /**
     * Calcula el volumen de un cilindro.
     * Fórmula: V = π * r² * h
     * @param radio Radio de la base
     * @param altura Altura del cilindro
     * @return El volumen del cilindro
     */
    public static double calcular(double radio, double altura) {
        if (radio <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Radio y altura deben ser positivos");
        }
        return Math.PI * radio * radio * altura;
    }

    public static void main(String[] args) {
        double radio = 3;
        double altura = 5;
        double volumen = calcular(radio, altura);

        System.out.println(String.format("Volumen del cilindro: %.2f", volumen));
    }
}