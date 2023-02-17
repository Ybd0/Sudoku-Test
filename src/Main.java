import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] Matrix1 = {2, 5, 9, 8, 7, 1, 6, 4, 3};
    static int[] Matrix2 = {3, 1, 4, 6, 2, 9, 5, 8, 7};
    static int[] Matrix3 = {7, 6, 8, 4, 5, 3, 1, 9, 2};
    static int[] Matrix4 = {9, 6, 7, 4, 1, 8, 3, 2, 5};
    static int[] Matrix5 = {8, 3, 5, 9, 7, 2, 4, 6, 1};
    static int[] Matrix6 = {2, 1, 4, 5, 3, 6, 9, 8, 7};
    static int[] Matrix7 = {7, 9, 6, 1, 8, 4, 5, 3, 2};
    static int[] Matrix8 = {2, 5, 3, 7, 9, 6, 1, 4, 8};
    static int[] Matrix9 = {8, 4, 1, 3, 2, 5, 6, 7, 9};


/*

    static int[] Matrix1 = { 1,  2,  3,  4,  5,  6,  7,  8,  9};
    static int[] Matrix2 = {10, 11, 12, 13, 14, 15, 16, 17, 18};
    static int[] Matrix3 = {19, 20, 21, 22, 23, 24, 25, 26, 27};
    static int[] Matrix4 = {28, 29, 30, 31, 32, 33, 34, 35, 36};
    static int[] Matrix5 = {37, 38, 39, 40, 41, 42, 43, 44, 45};
    static int[] Matrix6 = {46, 47, 48, 49, 50, 51, 52, 53, 54};
    static int[] Matrix7 = {55, 56, 57, 58, 59, 60, 61, 62, 63};
    static int[] Matrix8 = {64, 65, 66, 67, 68, 69, 70, 71, 72};
    static int[] Matrix9 = {73, 74, 75, 76, 77, 78, 79, 80, 81};

 */

    static ArrayList<Integer> xGlobalFalsch = new ArrayList<>();
    static ArrayList<Integer> yGlobalFalsch = new ArrayList<>();

    static ArrayList<Integer> matrixIndexFalsch = new ArrayList<>();

    public static void main(String[] args) {

        //replaceRandom();

        NxN nxnMatrix = initNxN();

        printSudoku();
       // nxnMatrix.print();
        nxnMatrix.rawprint();

        benutzerinteraktion();

    }

    private static NxN initNxN() {
        NxN nxn = new NxN();

        int x = 0;

        int y = 0;

        for (dxdMatrix dm : kM) {
            for (int i = 0; i < 3; i++) {
                for (int n = 0; n < 3; n++) {

                    int value = dm.getZelle(i, n);

                    nxn.add(x, y, value);
                    x++;

                }

            }

            if (x == 9) {
                x = 0;
            }
            y++;

        }

        return nxn;
    }

    public static final dxdMatrix[] kM = new dxdMatrix[] {
            new dxdMatrix(Matrix1),
            new dxdMatrix(Matrix2),
            new dxdMatrix(Matrix3),
            new dxdMatrix(Matrix4),
            new dxdMatrix(Matrix5),
            new dxdMatrix(Matrix6),
            new dxdMatrix(Matrix7),
            new dxdMatrix(Matrix8),
            new dxdMatrix(Matrix9)
    };

    public static void replaceRandom() {
        for (dxdMatrix dxdMatrix : kM) {
            int anzahlReplaceVon = 2; // Wie viele Zahlen in einer Matrix sollen minimal ersetzt werden
            int anzahlReplaceBis = 7; // Wie viele Zahlen in einer Matrix sollen maximal ersetzt werden
            int int_random = (int)Math.floor(Math.random()*(anzahlReplaceBis-anzahlReplaceVon+1)+anzahlReplaceVon);

            for (int i = 0; i < int_random; i++) {
                dxdMatrix.setZelle((int)Math.floor(Math.random()*(2 +1)+0), (int)Math.floor(Math.random()*(2 +1)+0), 0);
            }

        }

    }

    private static void printSudoku() {
        int nrKM = 0; // Nummer kleine Matrix
        int zeile = 0;
        int runZahler = 0;

        System.out.println("  --A-B-C----D-E-F----G-H-I---");

        int array = 0;

        while(true) {

            //System.out.println("☐");

            if (nrKM == 3) {

                System.out.println(" ");

                zeile ++;

                if (zeile >= 3) {
                    zeile = 0;
                    runZahler ++;
                    System.out.println("  ----------------------------");
                }

                nrKM = 0;

                array = (runZahler * 3);
            }

            if (runZahler == 3) {
                break;
            }

            for (int n = 0; n < 3; n++) {

                if (nrKM == 0 && n == 0) {
                    System.out.print(zeile + 1 + array + " ");
                    System.out.print("| ");
                }
                /*
                if (array == 0 && nrKM == 0) {
                    System.out.print(" ");
                }

                 */
                if (kM[array].getZelle(n, zeile) == 0) {
                    // todo
                    //System.out.print("?");
                    System.out.print((char) 27 + "[34m?");
                    System.out.print((char) 27 + "[0m ");
                } else {
                    System.out.print(kM[array].getZelle(n, zeile));
                    System.out.print(" ");
                }

            }

            System.out.print(" | ");

            nrKM ++;

            array++;

        }
    }

    public static void benutzerinteraktion() {
        String input;

        int xWertGlobal = 0;
        int yWertGlobal = 0;
        int xWertLokal = 0;
        int yWertLokal = 0;
        int matrixIndex = 0;

        System.out.println("Geben Sie einen Buchstaben ein");

        Scanner userInput = new Scanner(System.in);

        while (xWertGlobal == 0) {
            input = userInput.nextLine();

            if (input.length() > 1) {
                System.out.println("Nur einen Buchstaben eingeben");
            } else {

                switch (input) {
                    case "A":
                        xWertGlobal = 1;
                        break;
                    case "B":
                        xWertGlobal = 2;
                        break;
                    case "C":
                        xWertGlobal = 3;
                        break;
                    case "D":
                        xWertGlobal = 4;
                        break;
                    case "E":
                        xWertGlobal = 5;
                        break;
                    case "F":
                        xWertGlobal = 6;
                        break;
                    case "G":
                        xWertGlobal = 7;
                        break;
                    case "H":
                        xWertGlobal = 8;
                        break;
                    case "I":
                        xWertGlobal = 9;
                        break;
                    default:
                        System.out.println("Nur einen Großbuchstaben von A - I eingeben");
                }
            }

        }

        while (yWertGlobal == 0) {
            System.out.println("Geben Sie eine Zahl von 1 - 9 ein");
            input = userInput.nextLine();

            if (!input.isEmpty()) {
                try {
                    if (Integer.parseInt(input) < 10 && Integer.parseInt(input) > 0) {
                        yWertGlobal = Integer.parseInt(input);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Es können nur Zahlen eingeben werden");
                }
            }
        }
        
        System.out.println("xWertGlobal = " + xWertGlobal + " | yWertGlobal = " + yWertGlobal);

        // 3x3 Matrix Index bestimmen

        // Ist der x-Wert in einem Bereich von 1 - 3 (Matrix 1, 4, 7 möglich)

        // Ist der x-Wert in einem Bereich von 4 - 6 (Matrix 2, 5, 8 möglich)

        // Ist der x-Wert in einem Bereich von 7 - 9 (Matrix 3, 6, 9 möglich)

        if (((xWertGlobal - 1) / 3) < 1) { // Matrix 1, 4, 7
            if (((yWertGlobal - 1) / 3) < 1) { // Matrix 1
                matrixIndex = 1;
            } else if (((yWertGlobal - 1) / 3) < 2) { // Matrix 4
                matrixIndex = 4;
            } else if (((yWertGlobal - 1) / 3) < 3) { // Matrix 7
                matrixIndex = 7;
            }
        } else if (((xWertGlobal - 1) / 3) < 2) { // Matrix 2, 5, 8
            if (((yWertGlobal - 1) / 3) < 1) { // Matrix 2
                matrixIndex = 2;
            } else if (((yWertGlobal - 1) / 3) < 2) { // Matrix 5

                matrixIndex = 5;
            } else if (((yWertGlobal - 1) / 3) < 3) { // Matrix 8
                matrixIndex = 8;
            }
        } else { // Matrix 3, 6, 9
            if (((yWertGlobal - 1) / 3) < 1) { // Matrix 3
                matrixIndex = 3;
            } else if (((yWertGlobal - 1) / 3) < 2) { // Matrix 6
                matrixIndex = 6;
            } else if (((yWertGlobal - 1) / 3) < 3) { // Matrix 9
                matrixIndex = 9;
            }
        }

        System.out.println("Der Matrix index ist = " + matrixIndex);

        // 3x3 Matrix Index + Globale x,y-Koordinaten in lokale x,y-Koordinaten umwandeln

        // Switch mit case für jede Matrix, welche die zu trimmende Menge an der x und y Koordinate enthält

        switch (matrixIndex) {
            case 1:
                xWertLokal = xWertGlobal;
                yWertLokal = yWertGlobal;
                break;
            case 2:
                xWertLokal = xWertGlobal - 3;
                yWertLokal = yWertGlobal;
                break;
            case 3:
                xWertLokal = xWertGlobal - 6;
                yWertLokal = yWertGlobal;
                break;
            case 4:
                xWertLokal = xWertGlobal;
                yWertLokal = yWertGlobal - 3;
                break;
            case 7:
                xWertLokal = xWertGlobal;
                yWertLokal = yWertGlobal - 6;
                break;
            case 5:
                xWertLokal = xWertGlobal - 3;
                yWertLokal = yWertGlobal - 3;
                break;
            case 6:
                xWertLokal = xWertGlobal - 6;
                yWertLokal = yWertGlobal - 3;
                break;
            case 8:
                xWertLokal = xWertGlobal - 3;
                yWertLokal = yWertGlobal - 6;
                break;
            case 9:
                xWertLokal = xWertGlobal - 6;
                yWertLokal = yWertGlobal - 6;
        }

        System.out.println("Die lokalen Koordinaten der Auswahl sind x = " + xWertLokal + " und y = " + yWertLokal);

        // Zahl der Auswahl bestimmen

        System.out.println("Die Auswahl lautet: " + kM[(matrixIndex - 1)].getZelle((xWertLokal - 1), (yWertLokal - 1)));

        zahleinsetzen(matrixIndex, xWertLokal, yWertLokal);

    }

    public static void zahleinsetzen(int matrixIndex, int xWertLokal, int yWertLokal) {

        String input;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welche Zahl soll eingesetzt werden?");

        input = userInput.nextLine();

        while (true) {
            if (!input.isEmpty()) {
                try {
                    if (Integer.parseInt(input) < 10 && Integer.parseInt(input) > 0) {
                        kM[(matrixIndex - 1)].setZelle((xWertLokal - 1), (yWertLokal - 1), Integer.parseInt(input));
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Es können nur Zahlen eingeben werden");
                }
            }
        }

        printSudoku();

        eingabePrufen(matrixIndex, xWertLokal, yWertLokal);

    }

    public static void eingabePrufen(int matrixIndex, int xWertLokal, int yWertLokal) {

        // zuerst prüfen, ob Eingabe nicht schon in der Matrix existiert

        for (int i = 0; i < 3; i++) {

            for (int n = 0; n < 3; n++) {
                if (kM[(matrixIndex - 1)].getZelle((xWertLokal - 1), (yWertLokal - 1)) == kM[(matrixIndex - 1)].getZelle(n, i)) {
                    if (!((xWertLokal - 1) == n && (yWertLokal - 1) == i)) {
                        // Zwei gleiche Zahlen in einer Matrix wurden gefunden
                        xGlobalFalsch.add(xWertLokal);
                        yGlobalFalsch.add(yWertLokal);
                        if (!matrixIndexFalsch.contains(matrixIndex)) {
                            matrixIndexFalsch.add(matrixIndex);
                            System.out.println("schreibe Matrix auf");
                        } else {
                            System.out.println("schreibe Matrix nicht auf, schon da");
                        }
                        System.out.println((char) 27 + "[31mZahl bereits in der 3x3 Matrix vorhanden");
                        System.out.print((char) 27 + "[0m");
                        break;
                    }
                }

            }
        }

        // Dann prüfen, ob Eingabe nicht schon in der gesamten Sudoku Spalte und Zeile vorhanden ist

        // Mit Switch die zu prüfenden Matrizen finden

        int[] xprufen = new int[2];
        int[] yprufen = new int[2];

        switch (matrixIndex) {
            case 1:
                xprufen[0] = 2;
                xprufen[1] = 3;
                yprufen[0] = 4;
                yprufen[1] = 7;
                break;
            case 2:
                xprufen[0] = 1;
                xprufen[1] = 3;
                yprufen[0] = 5;
                yprufen[1] = 8;
                break;
            case 3:
                xprufen[0] = 2;
                xprufen[1] = 1;
                yprufen[0] = 6;
                yprufen[1] = 9;
                break;
            case 4:
                xprufen[0] = 5;
                xprufen[1] = 6;
                yprufen[0] = 1;
                yprufen[1] = 7;
                break;
            case 5:
                xprufen[0] = 4;
                xprufen[1] = 6;
                yprufen[0] = 2;
                yprufen[1] = 8;
                break;
            case 6:
                xprufen[0] = 4;
                xprufen[1] = 5;
                yprufen[0] = 3;
                yprufen[1] = 9;
                break;
            case 7:
                xprufen[0] = 8;
                xprufen[1] = 9;
                yprufen[0] = 1;
                yprufen[1] = 4;
                break;
            case 8:
                xprufen[0] = 7;
                xprufen[1] = 9;
                yprufen[0] = 2;
                yprufen[1] = 5;
                break;
            case 9:
                xprufen[0] = 7;
                xprufen[1] = 8;
                yprufen[0] = 3;
                yprufen[1] = 6;
                break;
        }

        // Zuerst die x-Achse überprüfen

        for (int i = 0; i < 2; i++) {
            for (int n = 0; n < 3; n++) {
                if (kM[(xprufen[i] - 1)].getZelle(n, (yWertLokal - 1)) == kM[(matrixIndex - 1)].getZelle((xWertLokal - 1), (yWertLokal - 1))) {
                    System.out.println((char) 27 + "[31mgleiche zahl in x-Achse gefunden");
                    System.out.print((char) 27 + "[0m");
                }
            }
        }

        // Dann die y-Achse überprüfen

        for (int i = 0; i < 2; i++) {
            for (int n = 0; n < 3; n++) {
                if (kM[(yprufen[i] - 1)].getZelle((xWertLokal - 1), n) == kM[(matrixIndex - 1)].getZelle((xWertLokal - 1), (yWertLokal - 1))) {
                    System.out.println((char) 27 + "[31mgleiche zahl in y-Achse gefunden");
                    System.out.print((char) 27 + "[0m");
                }
            }
        }

        benutzerinteraktion();
    }
}