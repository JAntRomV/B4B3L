package Code.Gemini.v1.Rare;

class ConvertidorTemperatura {
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}

public class UtilidadEstatica {
    public static void main(String[] args) {
        double tempCelsius = 20.0;
        double tempFahrenheit = ConvertidorTemperatura.celsiusAFahrenheit(tempCelsius);
        
        System.out.println(tempCelsius + "°C equivale a " + tempFahrenheit + "°F.");
    }
}
