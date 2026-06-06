package Code.Gemini.v1.Rare;

class AnimalPolimorfico {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido genérico.");
    }
}

class PerroPolimorfico extends AnimalPolimorfico {
    @Override
    public void hacerSonido() {
        System.out.println("El perro ladra: ¡Guau!");
    }
}

public class PruebaPolimorfismo {
    public static void main(String[] args) {
        AnimalPolimorfico miAnimal = new PerroPolimorfico();
        miAnimal.hacerSonido();
    }
}
