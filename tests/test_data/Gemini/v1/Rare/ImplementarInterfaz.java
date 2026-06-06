package Code.Gemini.v1.Rare;

interface Dibujable {
    void dibujar();
}

class Circulo implements Dibujable {
    public void dibujar() {
        System.out.println("Dibujando un círculo: O");
    }
}

public class ImplementarInterfaz {
    public static void main(String[] args) {
        Circulo miCirculo = new Circulo();
        miCirculo.dibujar();
    }
}
