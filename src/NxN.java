//x         y
public class NxN {

    private final Cell[][] nxn = new Cell[9][9];

    public Cell getCell(int x, int y) {
        return nxn[x][y];
    }

    public void add(int x, int y, int value) {

        nxn[x][y] = new Cell(value);
    }
    public void add(int index, int value) {

        int zeile = index / 9;
        int spalte = index % 9;

        nxn[spalte][zeile] = new Cell(value);
    }

    public void rawprint() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.println(nxn[x][y].getValue());
            }
            System.out.println();
        }
    }

    public void rawprint2() {
        for (Cell[] cellList : nxn) {
            for (Cell cell : cellList) {
                System.out.println(cell.getValue());
            }
            System.out.println();
        }
    }

    public void print() {
        int nrKM = 0; // Nummer kleine Matrix
        int zeile = 0;
        int runZahler = 0;

        System.out.println("  --A-B-C----D-E-F----G-H-I---");

        int index = 0;

        while(true) {

            //System.out.println("☐");

            if (nrKM == 1) {

                System.out.println(" ");

                zeile ++;

                if (zeile >= 9) {
                    zeile = 0;
                    runZahler ++;
                    System.out.println("  ----------------------------");
                    break;
                }

                nrKM = 0;

            }



            for (int n = 0; n < 9; n++) {

                if (nrKM == 0 && n == 0) {
                    System.out.print(zeile + 1 + index + " ");
                    System.out.print("| ");
                }
                /*
                if (index == 0 && nrKM == 0) {
                    System.out.print(" ");
                }

                 */


                if (nxn[n][zeile].isChangeable()) {
                    // todo
                    //System.out.print("?");
                    System.out.print((char) 27 + "[34m?");
                    System.out.print((char) 27 + "[0m ");
                } else {
                    System.out.print(nxn[n][zeile].getValue());
                    System.out.print(" ");
                }

            }

            System.out.print(" | ");

            nrKM ++;

            index++;

        }
    }
}
