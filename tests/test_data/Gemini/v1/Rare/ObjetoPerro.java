package Code.Gemini.v1.Rare;

class Perro {
    String nombre = "Fido";
    void ladrar() {
        System.out.println("¡Guau! ¡Guau!");
    }
}

public class ObjetoPerro {
    public static void main(String[] args) {
        Perro miPerro = new Perro();

        System.out.println("El nombre de mi perro es: " + miPerro.nombre);
        System.out.print("Mi perro hace: ");
        miPerro.ladrar();
    }
}
