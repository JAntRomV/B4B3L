package Code.Gemini.v1.Rare;

class Empleado {
    String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}

public class UsoDeThis {
    public static void main(String[] args) {
        Empleado emp = new Empleado("David");
        System.out.println("Nombre del empleado: " + emp.getNombre());
    }
}
