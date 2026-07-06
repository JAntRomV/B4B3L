package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el punto medio entre dos puntos.
 */
public class PuntoMedio {

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

        @Override
        public String toString() {
            return String.format("(%.2f, %.2f)", x, y);
        }
    }

    /**
     * Calcula el punto medio entre dos puntos.
     * @param p1 Primer punto
     * @param p2 Segundo punto
     * @return El punto medio
     */
    public static Punto calcular(Punto p1, Punto p2) {
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("Los puntos no pueden ser nulos");
        }

        double xMedio = (p1.x + p2.x) / 2;
        double yMedio = (p1.y + p2.y) / 2;

        return new Punto(xMedio, yMedio);
    }

    public static void main(String[] args) {
        Punto p1 = new Punto(2, 3);
        Punto p2 = new Punto(8, 7);

        Punto medio = calcular(p1, p2);

        System.out.println("Punto medio: " + medio);
    }
}