import org.graalvm.polyglot.*;

public class TareasPoliglota {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Ejecución Políglota de Tareas en PYTHON ===");
        
        try (Context context = Context.create()) {
            // Ejecución del bloque traducido usando GraalVM Truffle
            Value result = context.eval("python",
                "
                import sys\n
                def gestor_de_tareas():\n
                    tareas = []\n
                    while len(tareas) < 5:\n
                        tarea = input(\"Ingrese una tarea (o 'salir' para terminar): \")\n
                        if tarea.casefold() == \"salir\":\n
                            break\n
                        tareas.append(tarea)\n
                    print(\"\\nTareas guardadas:\")\n
                    for i, tarea in enumerate(tareas, start=1):\n
                        print(f\"{i}. {tarea}\")\n
                gestor_de_tareas()\n
                "
            );
            
            if (!result.isNull()) {
                System.out.println("\n-> Resultado final devuelto a Java: " + result);
            }
        } catch (Exception e) {
            System.err.println("❌ Error en la ejecución políglota: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
