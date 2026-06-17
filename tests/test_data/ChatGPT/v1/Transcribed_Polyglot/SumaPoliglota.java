import org.graalvm.polyglot.*;

public class SumaPoliglota {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Ejecución Políglota de Suma en PYTHON ===");

        try (Context context = Context.create()) {
            // Ejecución del bloque traducido usando GraalVM Truffle
            Value result = context.eval("python",
                    "import sys\n" +
                            "def suma_numeros():\n" +
                            "    num1 = int(input(\"Ingrese el primer número: \"))\n" +
                            "    num2 = int(input(\"Ingrese el segundo número: \"))\n" +
                            "    suma = num1 + num2\n" +
                            "    print(\"La suma es: \" + str(suma))\n" +
                            "suma_numeros()\n");

            if (!result.isNull()) {
                System.out.println("\n-> Resultado final devuelto a Java: " + result);
            }
        } catch (Exception e) {
            System.err.println("❌ Error en la ejecución políglota: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
