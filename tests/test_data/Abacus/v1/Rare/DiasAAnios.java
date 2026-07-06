package Code.Java.Abacus.v1.Rare;

public class DiasAAnios {
    public static void main(String[] args) {
        int dias = 730;
        int anios = dias / 365;
        int diasRestantes = dias % 365;
        System.out.println(dias + " días = " + anios + " años y " + diasRestantes + " días");
    }
}