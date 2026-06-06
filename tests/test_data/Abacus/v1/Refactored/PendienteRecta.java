package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la pendiente de una recta.
 */
public class PendienteRecta {

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
     * Calcula la pendiente de una recta que pasa por dos puntos.
     * @param p1 Primer punto
     * @param p2 Segundo punto
     * @return La pendiente
     * @throws ArithmeticException si la recta es vertical
     */
    public static double calcular(Punto p1, Punto p2) {
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("Los puntos no pueden ser nulos");
        }

        double dx = p2.x - p1.x;

        if (dx == 0) {
            throw new ArithmeticException("La recta es vertical (pendiente indefinida)");
        }

        double dy = p2.y - p1.y;
        return dy / dx;
    }

    public static void main(String[] args) {
        Punto p1 = new Punto(1, 2);
        Punto p2 = new Punto(3, 6);

        try {
            double pendiente = calcular(p1, p2);
            System.out.println(String.format("Pendiente de la recta: %.2f", pendiente));
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}