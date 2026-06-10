package Code.Java.Abacus.v1.Rare;

public class FuncionCoseno {
    public static void main(String[] args) {
        double angulo = 60; // grados
        double radianes = Math.toRadians(angulo);
        double coseno = Math.cos(radianes);
        System.out.println("Coseno de " + angulo + "° = " + coseno);
    }
}