package Code.Gemini.v1.Rare;

class Configuracion {
    private static final Configuracion instancia = new Configuracion();
    
    private Configuracion() {}
    
    public static Configuracion obtenerInstancia() {
        return instancia;
    }
}

public class PruebaConstructorPrivado {
    public static void main(String[] args) {
        Configuracion conf1 = Configuracion.obtenerInstancia();
        Configuracion conf2 = Configuracion.obtenerInstancia();
        
        System.out.println("Se obtuvo la instancia única de Configuración.");
    }
}
