package Code.Gemini.v1.Rare;

class Auto {
    void acelerar() {
        System.out.println("El coche acelera normalmente.");
    }
}

class AutoDeportivo extends Auto {
    @Override
    void acelerar() {
        System.out.println("¡El coche deportivo acelera rápidamente!");
    }
}

public class TallerMecanico {
    public static void main(String[] args) {
        Auto miAuto = new Auto();
        AutoDeportivo miDeportivo = new AutoDeportivo();
        
        miAuto.acelerar();
        miDeportivo.acelerar();
    }
}
