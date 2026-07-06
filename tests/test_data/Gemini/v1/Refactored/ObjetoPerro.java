package Code.Gemini.v1.Refactored;

/**
 * Clase Perro refactorizada con encapsulamiento (campos privados),
 * un constructor y un método getter.
 */
class Perro {
    private final String nombre;

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void ladrar() {
        System.out.println("¡Guau! ¡Guau!");
    }
}

/**
 * La clase principal ahora crea una instancia de Perro con un nombre específico.
 */
public class ObjetoPerro {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Fido");

        System.out.println("El nombre de mi perro es: " + miPerro.getNombre());
        System.out.print("Mi perro hace: ");
        miPerro.ladrar();
    }
}
