package Code.Gemini.v1.Rare;

public class CronometroSimple {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        for(int i = 0; i < 100000; i++) {
            // Tarea a medir
        }

        long fin = System.nanoTime();
        long duracion = (fin - inicio) / 1000000;

        System.out.println("La tarea tomó: " + duracion + " milisegundos.");
    }
}
