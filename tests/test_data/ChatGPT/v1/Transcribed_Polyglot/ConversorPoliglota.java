import org.graalvm.polyglot.*;

public class ConversorPoliglota {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Ejecución Políglota de Conversor en PYTHON ===");

        try (Context context = Context.create()) {
            // Ejecución del bloque traducido usando GraalVM Truffle
            Value result = context.eval("python",
                    "import math\n" +
                            "def conversor.temperatura_celsius_a_fahrenheit(celsius):\n" +
                            "    fahrenheit = (celsius * 9/5) + 32\n" +
                            "    return fahrenheit\n" +
                            "\n" +
                            "def main():\n" +
                            "    try:\n" +
                            "        celsius = float(input(\"Ingrese la temperatura en Celsius: \" ))\n" +
                            "        fahrenheit = conversor.temperatura_celsius_a_fahrenheit(celsius)\n" +
                            "        print(\"Equivalente en Fahrenheit: \" + str(fahrenheit))\n" +
                            "    except ValueError:\n" +
                            "        print(\"Error: Por favor ingrese un número válido.\")\n" +
                            "\n" +
                            "if __name__ == \"__main__\":\n" +
                            "    main()");

            if (!result.isNull()) {
                System.out.println("\n-> Resultado final devuelto a Java: " + result);
            }
        } catch (Exception e) {
            System.err.println("❌ Error en la ejecución políglota: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
