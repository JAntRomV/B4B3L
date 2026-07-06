import org.graalvm.polyglot.*;

public class FactorialPoliglota {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Ejecución Políglota de Factorial en PYTHON ===");

        try (Context context = Context.create()) {
            // Ejecución del bloque traducido usando GraalVM Truffle
            Value result = context.eval("python",
                    "import sys\n" +
                            "def calcular_factorial(numero):\n" +
                            "    factorial = 1\n" +
                            "    for i in range(1, numero + 1):\n" +
                            "        factorial *= i\n" +
                            "    return factorial\n" +
                            "def main():\n" +
                            "    try:\n" +
                            "        numero = int(input(\"Ingrese un número: \"))\n" +
                            "        factorial = calcular_factorial(numero)\n" +
                            "        print(\"El factorial de \" + str(numero) + \" es: \" + str(factorial))\n" +
                            "    except ValueError:\n" +
                            "        print(\"Error: ingrese un número válido.\")\n" +
                            "if __name__ == \"__main__\":\n" +
                            "    main()\n");

            if (!result.isNull()) {
                System.out.println("\n-> Resultado final devuelto a Java: " + result);
            }
        } catch (Exception e) {
            System.err.println("❌ Error en la ejecución políglota: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
