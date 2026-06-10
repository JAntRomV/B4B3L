package Code.Gemini.v1.Rare;

class Producto {
    private String nombre;
    private double precio;

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setPrecio(double nuevoPrecio) {
        if (nuevoPrecio > 0) {
            this.precio = nuevoPrecio;
        }
    }

    void mostrarDetalles() {
        System.out.println("Producto: " + nombre + ", Precio: $" + precio);
    }
}

public class Tienda {
    public static void main(String[] args) {
        Producto p1 = new Producto();
        p1.setNombre("Laptop");
        p1.setPrecio(1200.50);
        p1.mostrarDetalles();
    }
}
