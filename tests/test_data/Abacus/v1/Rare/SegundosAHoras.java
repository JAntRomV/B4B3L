package Code.Java.Abacus.v1.Rare;

public class SegundosAHoras {
    public static void main(String[] args) {
        int segundos = 3665;
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segs = segundos % 60;
        System.out.println(segundos + " segundos = " + horas + "h " + minutos + "m " + segs + "s");
    }
}