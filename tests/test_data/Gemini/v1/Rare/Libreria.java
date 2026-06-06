package Code.Gemini.v1.Rare;

class Libro {
    String titulo;
    String autor;

    public Libro(String t, String a) {
        titulo = t;
        autor = a;
    }

    void mostrarInfo() {
        System.out.println("Título: " + titulo + ", Autor: " + autor);
    }
}

public class Libreria {
    public static void main(String[] args) {
        Libro miLibro = new Libro("Don Quijote", "Miguel de Cervantes");
        miLibro.mostrarInfo();
    }
}
