package Code.Java.Abacus.v1.Rare;

public class MCM {
    public static void main(String[] args) {
        int a = 12, b = 18;
        int mcd = a;
        int temp = b;
        while (temp != 0) {
            int r = mcd % temp;
            mcd = temp;
            temp = r;
        }
        int mcm = (a * b) / mcd;
        System.out.println("MCM: " + mcm);
    }
}