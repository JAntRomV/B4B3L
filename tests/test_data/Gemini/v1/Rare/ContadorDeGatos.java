package Code.Gemini.v1.Rare;

class Gato {
    static int contadorDeGatos = 0;

    public Gato() {
        contadorDeGatos++;
    }
}

public class ContadorDeGatos {
    public static void main(String[] args) {
        System.out.println("Creando gatos...");
        
        Gato gato1 = new Gato();
        Gato gato2 = new Gato();
        Gato gato3 = new Gato();
        
        System.out.println("Número total de gatos creados: " + Gato.contadorDeGatos);
    }
}
