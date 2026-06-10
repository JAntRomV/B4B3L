package Code.Gemini.v1.Rare;

public class PequeñoRetraso {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando tarea...");
        Thread.sleep(2000); // Pausa la ejecución por 2000 milisegundos
        System.out.println("Tarea finalizada después de 2 segundos.");
    }
}
