package Code.Gemini.v1.Rare;

class Animal {
    void comer() {
        System.out.println("Este animal come comida.");
    }
}

class GatoDomestico extends Animal {
    void maullar() {
        System.out.println("¡Miau!");
    }
}

public class PruebaHerencia {
    public static void main(String[] args) {
        GatoDomestico miGato = new GatoDomestico();
        miGato.comer();
        miGato.maullar();
    }
}
