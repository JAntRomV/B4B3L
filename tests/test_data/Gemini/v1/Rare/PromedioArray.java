package Code.Gemini.v1.Rare;

public class PromedioArray {
    public static void main(String[] args) {
        double[] calificaciones = {8.5, 9.0, 7.8, 10.0, 6.5};
        double suma = 0.0;

        for (double calificacion : calificaciones) {
            suma += calificacion;
        }

        double promedio = suma / calificaciones.length;
        System.out.println("El promedio de las calificaciones es: " + promedio);
    }
}
