package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para demostrar la conversión en un método separado
 * y mostrar el valor perdido en el proceso.
 */
public class ConversionDeTipos {

    private static int convertirDoubleAInt(double numeroDecimal) {
        return (int) numeroDecimal;
    }

    public static void main(String[] args) {
        double precioConDecimales = 99.99;
        int precioSinDecimales = convertirDoubleAInt(precioConDecimales);
        
        System.out.println("Precio original (double): " + precioConDecimales);
        System.out.println("Precio convertido (int): " + precioSinDecimales);
        System.out.println("Información perdida: " + (precioConDecimales - precioSinDecimales));
    }
}
