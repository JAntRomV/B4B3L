import org.graalvm.polyglot.*;

public class AdivinaPoliglota {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Ejecución Políglota de Adivina en PYTHON ===");

        try (Context context = Context.create()) {
            // Ejecución del bloque traducido usando GraalVM Truffle
            Value result = context.eval("python",
                    "import random\n" +
                            "def adivina():\n" +
                            "    numero_secreto = random.randint(1, 10)\n" +
                            "    intento = int(input(\"Adivina el número (entre 1 y 10): \" ))\n" +
                            "    if intento == numero_secreto:\n" +
                            "        print(\"¡Correcto! Adivinaste el número.\")\n" +
                            "    else:\n" +
                            "        print(\"Incorrecto, el número era: \" + str(numero_secreto))\n" +
                            "adivina()\n");

            if (!result.isNull()) {
                System.out.println("\n-> Resultado final devuelto a Java: " + result);
            }
        } catch (Exception e) {
            System.err.println("❌ Error en la ejecución políglota: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
