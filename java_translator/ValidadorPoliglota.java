// Archivo temporal para probar los motores de ejecución.
// Lo dejamos en el paquete java_translator para que se compile junto a los otros.

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class ValidadorPoliglota {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Motor Políglota de B4B3L ===");

        try (Context context = Context.create()) {

            // 1. Probar Ejecución de JavaScript
            String codigoJS = "const sumar = (a, b) => a + b; sumar(10, 5);";
            Value resultadoJS = context.eval("js", codigoJS);
            System.out.println("-> Resultado desde JavaScript: " + resultadoJS.asInt());

            // 2. Probar Ejecución de Python
            String codigoPY = "def multiplicar(a, b): return a * b\nmultiplicar(10, 5)";
            Value resultadoPY = context.eval("python", codigoPY);
            System.out.println("-> Resultado desde Python: " + resultadoPY.asInt());

        } catch (Exception e) {
            System.err.println("❌ Error en el entorno políglota: " + e.getMessage());
            e.printStackTrace();
        }
    }
}