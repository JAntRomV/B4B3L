package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la distancia euclidiana entre dos puntos.
 */
public class DistanciaEuclidiana {

    /**
     * Clase interna para representar un punto en 2D.
     */
    public static class Punto {
        public final double x;
        public final double y;

        public Punto(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Calcula la distancia euclidiana entre dos puntos.
     * @param p1 Primer punto
     * @param p2 Segundo punto
     * @return La distancia euclidiana
     */
    public static double calcular(Punto p1, Punto p2) {
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("Los puntos no pueden ser nulos");
        }

        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calcula la distancia euclidiana usando coordenadas directas.
     * @param x1 Coordenada x del primer punto
     * @param y1 Coordenada y del primer punto
     * @param x2 Coordenada x del segundo punto
     * @param y2 Coordenada y del segundo punto
     * @return La distancia euclidiana
     */
    public static double calcular(double x1, double y1, double x2, double y2) {
        return calcular(new Punto(x1, y1), new Punto(x2, y2));
    }

    public static void main(String[] args) {
        Punto p1 = new Punto(1, 2);
        Punto p2 = new Punto(4, 6);

        double distancia = calcular(p1, p2);

        System.out.println(String.format("Distancia euclidiana: %.2f", distancia));
    }
}