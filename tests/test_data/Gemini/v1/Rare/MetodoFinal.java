package Code.Gemini.v1.Rare;

class Vehiculo {
    public final void mostrarMarca() {
        System.out.println("Marca genérica de vehículo.");
    }
}

class Coche extends Vehiculo {
    // No se puede sobreescribir mostrarMarca()
}

public class MetodoFinal {
    public static void main(String[] args) {
        Coche miCoche = new Coche();
        miCoche.mostrarMarca();
    }
}
