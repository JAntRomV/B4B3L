package Code.Gemini.v1.Rare;

public class ConversionDeTipos {
    public static void main(String[] args) {
        double precioConDecimales = 99.99;
        
        int precioSinDecimales = (int) precioConDecimales;
        
        System.out.println("Precio original (double): " + precioConDecimales);
        System.out.println("Precio convertido (int): " + precioSinDecimales);
    }
}
