public class dxdMatrix {
    private final int[][] Zelle = new int[3][3];
    static int[] Matrix;

    public dxdMatrix(int[] Matrix) {
        dxdMatrix.Matrix = Matrix;
        zelleBefuellen();
    }
    public void zelleBefuellen(){
        int zeile = 0;

        for (int i = 0; i < 3; i++) {

            for (int n = 0; n < 3; n++) {
                this.Zelle[n][i] = Matrix[zeile];
                zeile++;
            }
        }
    }
    public int getZelle(int xKoordinate, int yKoordinate) {
        return Zelle[xKoordinate][yKoordinate];
    }

    public void setZelle(int xKoordinate, int yKoordinate, int wert) {
        Zelle[xKoordinate][yKoordinate] = wert;
    }
}