import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /*
    static int[] Matrix1 = {2, 5, 9, 8, 7, 1, 6, 4, 3};
    static int[] Matrix2 = {3, 1, 4, 6, 2, 9, 5, 8, 7};
    static int[] Matrix3 = {7, 6, 8, 4, 5, 3, 1, 9, 2};
    static int[] Matrix4 = {9, 6, 7, 4, 1, 8, 3, 2, 5};
    static int[] Matrix5 = {8, 3, 5, 9, 7, 2, 4, 6, 1};
    static int[] Matrix6 = {2, 1, 4, 5, 3, 6, 9, 8, 7};
    static int[] Matrix7 = {7, 9, 6, 1, 8, 4, 5, 3, 2};
    static int[] Matrix8 = {2, 5, 3, 7, 9, 6, 1, 4, 8};
    static int[] Matrix9 = {8, 4, 1, 3, 2, 5, 6, 7, 9};


     */
    public static SudokuBoard board;

    static ArrayList<int[]> allMatrices = new ArrayList<>();
    static ArrayList<String> xyGlobalFalsch = new ArrayList<>();
    static ArrayList<ArrayList<String>> xyGlobalCause = new ArrayList<>();
    static int mistakes = 0;
    static int mistakesMax = 0;
    static int wins = 0;
    static int checks = 0;
    static long lastGameTime = 0;
    static long lastWonGameTime = 0;
    static long startTime = 0;

    static String difficulty;
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


    static int[] Matrix1 = { 1,  2,  3,  2,  3,  4,  3,  4,  5};
    static int[] Matrix2 = { 4,  5,  6,  5,  6,  7,  6,  7,  8};
    static int[] Matrix3 = { 7,  8,  9,  8,  9,  1,  9,  1,  2};
    static int[] Matrix4 = { 4,  5,  6,  5,  6,  7,  6,  7,  8};
    static int[] Matrix5 = { 7,  8,  9,  8,  9,  1,  9,  1,  2};
    static int[] Matrix6 = { 1,  2,  3,  2,  3,  4,  3,  4,  5};
    static int[] Matrix7 = { 7,  8,  9,  8,  9,  1,  9,  1,  2};
    static int[] Matrix8 = { 1,  2,  3,  2,  3,  4,  3,  4,  5};
    static int[] Matrix9 = { 4,  5,  6,  5,  6,  7,  6,  7,  8};





    public static void main(String[] args) {

        int[] matrix1 = {1,  2,  3,  2,  3,  4,  3,  4,  5};
        System.arraycopy(matrix1, 0, Matrix1, 0, 9);

        int[] matrix2 = {4,  5,  6,  5,  6,  7,  6,  7,  8};
        System.arraycopy(matrix2, 0, Matrix2, 0, 9);

        int[] matrix3 = {7,  8,  9,  8,  9,  1,  9,  1,  2};
        System.arraycopy(matrix3, 0, Matrix3, 0, 9);

        int[] matrix4 = {4,  5,  6,  5,  6,  7,  6,  7,  8};
        System.arraycopy(matrix4, 0, Matrix4, 0, 9);

        int[] matrix5 = {7,  8,  9,  8,  9,  1,  9,  1,  2};
        System.arraycopy(matrix5, 0, Matrix5, 0, 9);

        int[] matrix6 = {1,  2,  3,  2,  3,  4,  3,  4,  5};
        System.arraycopy(matrix6, 0, Matrix6, 0, 9);

        int[] matrix7 = {7,  8,  9,  8,  9,  1,  9,  1,  2};
        System.arraycopy(matrix7, 0, Matrix7, 0, 9);

        int[] matrix8 = {1,  2,  3,  2,  3,  4,  3,  4,  5};
        System.arraycopy(matrix8, 0, Matrix8, 0, 9);

        int[] matrix9 = {4,  5,  6,  5,  6,  7,  6,  7,  8};
        System.arraycopy(matrix9, 0, Matrix9, 0, 9);

        board = new SudokuBoard();

        GererateSudoku.fillArray();

        System.out.println();

        Matrix m1 = new Matrix();

        Matrix m2 = new Matrix();

        Matrix m3 = new Matrix();

        Matrix m4 = new Matrix();

        Matrix m5 = new Matrix();

        Matrix m6 = new Matrix();

        Matrix m7 = new Matrix();

        Matrix m8 = new Matrix();

        Matrix m9 = new Matrix();

        // must replace random numbers in arrays before they are being added

        allMatrices.add(Matrix1);
        allMatrices.add(Matrix2);
        allMatrices.add(Matrix3);
        allMatrices.add(Matrix4);
        allMatrices.add(Matrix5);
        allMatrices.add(Matrix6);
        allMatrices.add(Matrix7);
        allMatrices.add(Matrix8);
        allMatrices.add(Matrix9);

        setDifficulty();

        setGameOverCondition();

        m1.add(new ArrayList<>(){{
            add(new Cell(Matrix1[0]));
            add(new Cell(Matrix1[1]));
            add(new Cell(Matrix1[2]));
        }});
        m1.add(new ArrayList<>(){{
            add(new Cell(Matrix1[3]));
            add(new Cell(Matrix1[4]));
            add(new Cell(Matrix1[5]));
        }});
        m1.add(new ArrayList<>(){{
            add(new Cell(Matrix1[6]));
            add(new Cell(Matrix1[7]));
            add(new Cell(Matrix1[8]));
        }});

        m2.add(new ArrayList<>(){{
            add(new Cell(Matrix2[0]));
            add(new Cell(Matrix2[1]));
            add(new Cell(Matrix2[2]));
        }});
        m2.add(new ArrayList<>(){{
            add(new Cell(Matrix2[3]));
            add(new Cell(Matrix2[4]));
            add(new Cell(Matrix2[5]));
        }});
        m2.add(new ArrayList<>(){{
            add(new Cell(Matrix2[6]));
            add(new Cell(Matrix2[7]));
            add(new Cell(Matrix2[8]));
        }});

        m3.add(new ArrayList<>(){{
            add(new Cell(Matrix3[0]));
            add(new Cell(Matrix3[1]));
            add(new Cell(Matrix3[2]));
        }});
        m3.add(new ArrayList<>(){{
            add(new Cell(Matrix3[3]));
            add(new Cell(Matrix3[4]));
            add(new Cell(Matrix3[5]));
        }});
        m3.add(new ArrayList<>(){{
            add(new Cell(Matrix3[6]));
            add(new Cell(Matrix3[7]));
            add(new Cell(Matrix3[8]));
        }});

        m4.add(new ArrayList<>(){{
            add(new Cell(Matrix4[0]));
            add(new Cell(Matrix4[1]));
            add(new Cell(Matrix4[2]));
        }});
        m4.add(new ArrayList<>(){{
            add(new Cell(Matrix4[3]));
            add(new Cell(Matrix4[4]));
            add(new Cell(Matrix4[5]));
        }});
        m4.add(new ArrayList<>(){{
            add(new Cell(Matrix4[6]));
            add(new Cell(Matrix4[7]));
            add(new Cell(Matrix4[8]));
        }});

        m5.add(new ArrayList<>(){{
            add(new Cell(Matrix5[0]));
            add(new Cell(Matrix5[1]));
            add(new Cell(Matrix5[2]));
        }});
        m5.add(new ArrayList<>(){{
            add(new Cell(Matrix5[3]));
            add(new Cell(Matrix5[4]));
            add(new Cell(Matrix5[5]));
        }});
        m5.add(new ArrayList<>(){{
            add(new Cell(Matrix5[6]));
            add(new Cell(Matrix5[7]));
            add(new Cell(Matrix5[8]));
        }});

        m6.add(new ArrayList<>(){{
            add(new Cell(Matrix6[0]));
            add(new Cell(Matrix6[1]));
            add(new Cell(Matrix6[2]));
        }});
        m6.add(new ArrayList<>(){{
            add(new Cell(Matrix6[3]));
            add(new Cell(Matrix6[4]));
            add(new Cell(Matrix6[5]));
        }});
        m6.add(new ArrayList<>(){{
            add(new Cell(Matrix6[6]));
            add(new Cell(Matrix6[7]));
            add(new Cell(Matrix6[8]));
        }});

        m7.add(new ArrayList<>(){{
            add(new Cell(Matrix7[0]));
            add(new Cell(Matrix7[1]));
            add(new Cell(Matrix7[2]));
        }});
        m7.add(new ArrayList<>(){{
            add(new Cell(Matrix7[3]));
            add(new Cell(Matrix7[4]));
            add(new Cell(Matrix7[5]));
        }});
        m7.add(new ArrayList<>(){{
            add(new Cell(Matrix7[6]));
            add(new Cell(Matrix7[7]));
            add(new Cell(Matrix7[8]));
        }});
        m8.add(new ArrayList<>(){{
            add(new Cell(Matrix8[0]));
            add(new Cell(Matrix8[1]));
            add(new Cell(Matrix8[2]));
        }});
        m8.add(new ArrayList<>(){{
            add(new Cell(Matrix8[3]));
            add(new Cell(Matrix8[4]));
            add(new Cell(Matrix8[5]));
        }});
        m8.add(new ArrayList<>(){{
            add(new Cell(Matrix8[6]));
            add(new Cell(Matrix8[7]));
            add(new Cell(Matrix8[8]));
        }});
        m9.add(new ArrayList<>(){{
            add(new Cell(Matrix9[0]));
            add(new Cell(Matrix9[1]));
            add(new Cell(Matrix9[2]));
        }});
        m9.add(new ArrayList<>(){{
            add(new Cell(Matrix9[3]));
            add(new Cell(Matrix9[4]));
            add(new Cell(Matrix9[5]));
        }});
        m9.add(new ArrayList<>(){{
            add(new Cell(Matrix9[6]));
            add(new Cell(Matrix9[7]));
            add(new Cell(Matrix9[8]));
        }});


        // Build the board with the sub matrices
        //SudokuBoard board = SudokuBoard.getInstance();
        board.add(m1);
        board.add(m2);
        board.add(m3);
        board.add(m4);
        board.add(m5);
        board.add(m6);
        board.add(m7);
        board.add(m8);
        board.add(m9);


        printSudoku();

        startTime = System.currentTimeMillis();


        benutzerinteraktion();
    }

    public static void setDifficulty() {
        System.out.println("Sudoku");
        System.out.println();
        System.out.println("Schwierigkeitsgrad einstellen: 1 - Einfach, 2 - Mittel, 3 - Schwer");

        String input;

        Scanner userInput = new Scanner(System.in);

        while (true) {
            input = userInput.nextLine();

            int min = 0;
            int max = 0;

            try {
                switch (Integer.parseInt(input)) {
                    case 1 -> {
                        min = 2;
                        max = 5;
                        difficulty = "einfach";
                    }
                    case 2 -> {
                        min = 4;
                        max = 7;
                        difficulty = "mittel";
                    }
                    case 3 -> {
                        min = 6;
                        max = 9;
                        difficulty = "schwer";
                    }
                    default -> System.out.println("Nur eine Zahl von 1 - 3 eingeben");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nur eine Zahl eingeben");
            }

            if (min != 0) {
                replaceRandom(min, max, setSeed());
                break;
            }
        }
    }

    public static void setGameOverCondition() {
        System.out.println();
        System.out.println("Nach wie vielen Fehlern soll das Spiel beendet werden?");
        System.out.println("0 - Spiel nicht beenden, >= 1 - Spiel nach einem oder mehreren Fehlern beenden");

        String input;

        Scanner userInput = new Scanner(System.in);

        while (true) {
            input = userInput.nextLine();

            try {
                if (Integer.parseInt(input) == 0) {
                    mistakesMax = 0;
                    System.out.println("Das Spiel wird nicht basierend auf Fehlern beendet");
                    break;
                } else if (Integer.parseInt(input) > 0) {
                    mistakesMax = Integer.parseInt(input);
                    System.out.println("Das Spiel wird nach " + mistakesMax + " Fehlern beendet");
                    break;
                } else {
                    System.out.println("Es können nur Zahlen größer gleich 0 eingegeben werden");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nur Zahlen eingeben");
            }
        }
    }

    public static int setSeed() {
        System.out.println();
        System.out.println("Soll ein bestimmter Seed benutzt werden? (0 = zufälliger Seed | > 0 = Seed)");

        int seed;

        String input;

        Scanner userInput = new Scanner(System.in);

        input = userInput.nextLine();

        while (true) {
            try {
                if (Integer.parseInt(input) == 0) {
                    seed = (int)Math.floor(Math.random()*(1000000 +1)+0);
                    System.out.println("Ein zufälliger Seed wird benutzt");
                    System.out.println(seed + " wird als Seed benutzt");
                    return seed;
                }

                if (Integer.parseInt(input) > 0) {
                    System.out.println(Integer.parseInt(input) + " wird als Seed benutzt");
                    seed = Integer.parseInt(input);
                    return seed;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nur Zahlen eingeben");
            }
        }
    }

    public static void replaceRandom(int min, int max, int seed) {

        Random random = new Random();

        int randomNum;

        for (int i = 0; i < 9; i++) {

            random.setSeed(seed);

            randomNum = random.nextInt(max - min) + min;

            int randomIndex;

            for (int o = 0; o < randomNum; o++) {

                randomIndex = random.nextInt(9);
                seed ++;
                allMatrices.get(i)[randomIndex] = 0;
            }
        }
    }

    private static void printSudoku() {
        int nrKM = 0; // Nummer an gezeichneten Zeilen von sub Matrizen / Number of printed rows from sub matrices
        int zeile = 0;
        int runZahler = 0;

        //SudokuBoard board = SudokuBoard.getInstance();

        if (mistakesMax == 0) {
            System.out.println("Fehler: " + mistakes + " (keine Grenze)" + " | " + "Schweregrad: " + difficulty);
        } else {
            System.out.println("Fehler: " + mistakes + "/" + mistakesMax + " | " + "Schweregrad: " + difficulty);
        }

        System.out.println("  --A-B-C----D-E-F----G-H-I---");

        int array = 0;

        while(true) {

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

                if (board.get(array).getCell(zeile, n).getValue() == 0) {
                    System.out.print((char) 27 + "[34m?");
                    System.out.print((char) 27 + "[0m ");
                } else if (board.get(array).getCell(zeile, n).isWrong()) {
                    System.out.print((char) 27 + "[31m" + board.get(array).getCell(zeile, n).getValue());
                    System.out.print((char) 27 + "[0m ");
                } else if (board.get(array).getCell(zeile, n).isChangeable()) {
                    System.out.print((char) 27 + "[33m" + board.get(array).getCell(zeile, n).getValue());
                    System.out.print((char) 27 + "[0m ");
                } else if (board.get(array).getCell(zeile, n).isCause()) {
                    System.out.print((char) 27 + "[90m" + board.get(array).getCell(zeile, n).getValue());
                    System.out.print((char) 27 + "[0m ");
                } else {
                    System.out.print(board.get(array).getCell(zeile, n).getValue());
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

        //SudokuBoard board = SudokuBoard.getInstance();

        int xWertGlobal = 0;
        int yWertGlobal = 0;
        int xWertLokal = 0;
        int yWertLokal = 0;
        int matrixIndex = 0;

        System.out.println("Geben Sie einen Buchstaben ein | Geben Sie \"ende\" ein um das Sudoku zu beenden");

        Scanner userInput = new Scanner(System.in);

        while (xWertGlobal == 0) {
            input = userInput.nextLine();

            if (input.equals("ende")) {
                if (xyGlobalFalsch.size() > 0) {
                    System.out.println("Das Sudoku wurde mit Fehlern beendet");
                    long endTime = System.currentTimeMillis();
                    lastGameTime = (endTime - startTime);
                    System.out.println("Benötigte Zeit: " + (lastGameTime  / 60000) + " min" + " : " + ((lastGameTime / 60000 * 60) - (lastGameTime  / 1000)) + " sek");
                    String[] args = {};
                    board = null;
                    main(args);
                } else {
                    for (int i = 0; i < 9; i++) {
                        for (int y = 0; y <3; y++) {
                            for (int x = 0; x < 3; x++) {
                                if (board.get(i).getCell(y, x).getValue() == 0) {
                                    System.out.println("Das Sudoku wurde nicht vollständig ausgefüllt");
                                    long endTime = System.currentTimeMillis();
                                    lastGameTime = (endTime - startTime);
                                    System.out.println("Benötigte Zeit: " + (lastGameTime  / 60000) + " min" + " : " + ((lastGameTime / 60000 * 60) - (lastGameTime  / 1000)) + " sek");
                                    String[] args = {};
                                    board = null;
                                    main(args);

                                }
                            }
                        }
                    }
                    System.out.println("Das Sudoku wurde ohne Fehler beendet");
                    wins ++;
                    long endTime = System.currentTimeMillis();
                    lastGameTime = (endTime - startTime);
                    System.out.println("Benötigte Zeit: " + (lastGameTime  / 60000) + " min" + " : " + ((lastGameTime / 60000 * 60) - (lastGameTime  / 1000)) + " sek");
                    board = null;
                    String[] args = {};
                    main(args);
                }
            }

            if (input.length() > 1) {
                System.out.println("Nur einen Buchstaben eingeben");
            }

            input = input.toUpperCase();

            switch (input) {
                case "A" -> xWertGlobal = 1;
                case "B" -> xWertGlobal = 2;
                case "C" -> xWertGlobal = 3;
                case "D" -> xWertGlobal = 4;
                case "E" -> xWertGlobal = 5;
                case "F" -> xWertGlobal = 6;
                case "G" -> xWertGlobal = 7;
                case "H" -> xWertGlobal = 8;
                case "I" -> xWertGlobal = 9;
                default -> System.out.println("Nur einen Großbuchstaben von A - I eingeben");
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

        // 3x3 Matrix Index bestimmen / Get index of sub matrix

        // Ist der x-Wert in einem Bereich von 1 - 3 (Matrix 1, 4, 7 möglich) / Is the x-Value in a scope of 1 - 3

        // Ist der x-Wert in einem Bereich von 4 - 6 (Matrix 2, 5, 8 möglich) / Is the x-Value in a scope of 4 - 6

        // Ist der x-Wert in einem Bereich von 7 - 9 (Matrix 3, 6, 9 möglich) / Is the x-Value in a scope of 7 - 9

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

        // 3x3 Matrix Index + Globale x,y-Koordinaten in lokale x,y-Koordinaten umwandeln / sub matrix index + translate global x,y-coordinates to local x,y-coordinates

        // Switch mit case für jede Matrix, welche die zu trimmende Menge an der x und y Koordinate enthält / Switch with case for every matrix, containing the amount, with wich the x and y coordinates should be trimmed

        switch (matrixIndex) {
            case 1 -> {
                xWertLokal = xWertGlobal;
                yWertLokal = yWertGlobal;
            }
            case 2 -> {
                xWertLokal = xWertGlobal - 3;
                yWertLokal = yWertGlobal;
            }
            case 3 -> {
                xWertLokal = xWertGlobal - 6;
                yWertLokal = yWertGlobal;
            }
            case 4 -> {
                xWertLokal = xWertGlobal;
                yWertLokal = yWertGlobal - 3;
            }
            case 7 -> {
                xWertLokal = xWertGlobal;
                yWertLokal = yWertGlobal - 6;
            }
            case 5 -> {
                xWertLokal = xWertGlobal - 3;
                yWertLokal = yWertGlobal - 3;
            }
            case 6 -> {
                xWertLokal = xWertGlobal - 6;
                yWertLokal = yWertGlobal - 3;
            }
            case 8 -> {
                xWertLokal = xWertGlobal - 3;
                yWertLokal = yWertGlobal - 6;
            }
            case 9 -> {
                xWertLokal = xWertGlobal - 6;
                yWertLokal = yWertGlobal - 6;
            }
        }

        zahleinsetzen(matrixIndex, xWertLokal, yWertLokal);

    }

    public static void zahleinsetzen(int matrixIndex, int xWertLokal, int yWertLokal) {

        String input;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welche Zahl soll eingesetzt werden?");

        input = userInput.nextLine();

        //SudokuBoard board = SudokuBoard.getInstance();

        while (true) {
            if (!input.isEmpty()) {
                try {
                    if (Integer.parseInt(input) < 10 && Integer.parseInt(input) > 0) {
                        if (board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).isChangeable()) { //Prüfen, ob Zelle verändert werden kann / Test if Cell can be changed
                            board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).setValue(Integer.parseInt(input));
                        } else {
                            System.out.println("Diese Stelle kann nicht verändert werden");
                        }
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Es können nur Zahlen eingeben werden");
                }
            }
        }

        checks = xyGlobalFalsch.size();

        checkInput(matrixIndex, xWertLokal, yWertLokal, true);

    }

    public static void checkInput(int matrixIndex, int xWertLokal, int yWertLokal, boolean firstRun) {

        // zuerst prüfen, ob Eingabe nicht schon in der Matrix existiert / first, test if input does not already exist in sub matrix

        //SudokuBoard board = SudokuBoard.getInstance();

        xyGlobalCause.add(new ArrayList<String>());

        boolean fehler = false;

        for (int i = 0; i < 3; i++) {

            for (int n = 0; n < 3; n++) {
                if (Objects.equals(board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).getValue(), board.get((matrixIndex - 1)).getCell(i, n).getValue())) {
                    if (!((xWertLokal - 1) == n && (yWertLokal - 1) == i)) { // Ausschließen, dass die Eingabe mit sich selbst verglichen wurde / Exclude, that input is not compared to itself
                        // Zwei gleiche Zahlen in der Matrix wurden gefunden / Two equal numbers where found in the sub matrix
                        fehler = true;
                        board.get((matrixIndex - 1)).getCell(i, n).setCause(true);
                        xyGlobalCause.get(xyGlobalCause.size()-1).add(String.valueOf(matrixIndex) + yWertLokal + xWertLokal + i + n + 0);
                        board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).setWrong(true);
                        if (!xyGlobalFalsch.contains(String.valueOf(matrixIndex) + yWertLokal + xWertLokal)) {
                            xyGlobalFalsch.add(String.valueOf(matrixIndex) + yWertLokal + xWertLokal);
                        }
                        System.out.println((char) 27 + "[31m" + "Zahl bereits in der 3x3 Matrix vorhanden");
                        System.out.print((char) 27 + "[0m");
                        break;
                    }
                }

            }
        }

        // Dann prüfen, ob Eingabe nicht schon in der gesamten Sudoku Spalte und Zeile vorhanden ist / Then examine, that input is not already present in the entire row and column of the Sudoku

        // Mit Switch die zu prüfenden Matrizen finden / Using a switch, find the matrices to be examined

        int[] xprufen = new int[2];
        int[] yprufen = new int[2];

        switch (matrixIndex) {
            case 1 -> {
                xprufen[0] = 2;
                xprufen[1] = 3;
                yprufen[0] = 4;
                yprufen[1] = 7;
            }
            case 2 -> {
                xprufen[0] = 1;
                xprufen[1] = 3;
                yprufen[0] = 5;
                yprufen[1] = 8;
            }
            case 3 -> {
                xprufen[0] = 2;
                xprufen[1] = 1;
                yprufen[0] = 6;
                yprufen[1] = 9;
            }
            case 4 -> {
                xprufen[0] = 5;
                xprufen[1] = 6;
                yprufen[0] = 1;
                yprufen[1] = 7;
            }
            case 5 -> {
                xprufen[0] = 4;
                xprufen[1] = 6;
                yprufen[0] = 2;
                yprufen[1] = 8;
            }
            case 6 -> {
                xprufen[0] = 4;
                xprufen[1] = 5;
                yprufen[0] = 3;
                yprufen[1] = 9;
            }
            case 7 -> {
                xprufen[0] = 8;
                xprufen[1] = 9;
                yprufen[0] = 1;
                yprufen[1] = 4;
            }
            case 8 -> {
                xprufen[0] = 7;
                xprufen[1] = 9;
                yprufen[0] = 2;
                yprufen[1] = 5;
            }
            case 9 -> {
                xprufen[0] = 7;
                xprufen[1] = 8;
                yprufen[0] = 3;
                yprufen[1] = 6;
            }
        }

        // Zuerst die x-Achse überprüfen / first examine the x-Axis

        for (int i = 0; i < 2; i++) {
            for (int n = 0; n < 3; n++) {
                if (Objects.equals(board.get((xprufen[i] - 1)).getCell((yWertLokal - 1), n).getValue(), board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).getValue())) {
                    fehler = true;
                    board.get((xprufen[i] - 1)).getCell((yWertLokal - 1), n).setCause(true);
                    xyGlobalCause.get(xyGlobalCause.size()-1).add(String.valueOf(matrixIndex) + yWertLokal + xWertLokal + xprufen[i] + n + 1);
                    board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).setWrong(true);
                    if (!xyGlobalFalsch.contains(String.valueOf(matrixIndex) + yWertLokal + xWertLokal)) {
                        xyGlobalFalsch.add(String.valueOf(matrixIndex) + yWertLokal + xWertLokal);
                    }
                    System.out.println((char) 27 + "[31m" + "gleiche Zahl in x-Achse gefunden");
                    System.out.print((char) 27 + "[0m");
                }
            }
        }

        // Dann die y-Achse überprüfen / Then examine the y-Axis

        for (int i = 0; i < 2; i++) {
            for (int n = 0; n < 3; n++) {
                if (Objects.equals(board.get((yprufen[i] - 1)).getCell(n, (xWertLokal - 1)).getValue(), board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).getValue())) {
                    fehler = true;
                    board.get((yprufen[i] - 1)).getCell(n, (xWertLokal - 1)).setCause(true);
                    xyGlobalCause.get(xyGlobalCause.size()-1).add(String.valueOf(matrixIndex) + yWertLokal + xWertLokal + yprufen[i] + n + 2);
                    board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).setWrong(true);
                    if (!xyGlobalFalsch.contains(String.valueOf(matrixIndex) + yWertLokal + xWertLokal)) {
                        xyGlobalFalsch.add(String.valueOf(matrixIndex) + yWertLokal + xWertLokal);
                    }
                    System.out.println((char) 27 + "[31m" + "gleiche Zahl in y-Achse gefunden");
                    System.out.print((char) 27 + "[0m");
                }
            }
        }

        // Falls Eingabe ohne Fehler, auf Eintrag in der Fehlerliste prüfen und falls vorhanden löschen / In case input has no mistakes, look for entry in mistake list and delete if present

        if (!fehler) {
            if (xyGlobalFalsch.contains(String.valueOf(matrixIndex) + yWertLokal + xWertLokal)) {
                xyGlobalFalsch.remove(String.valueOf(matrixIndex) + yWertLokal + xWertLokal);
                board.get((matrixIndex - 1)).getCell((yWertLokal - 1), (xWertLokal - 1)).setWrong(false);
                // Delete cause for wrong cell
                for (ArrayList<String> strings : xyGlobalCause) {
                    if (strings.size() > 0) {
                        int mI = Integer.parseInt(String.valueOf(strings.get(0).charAt(0)));
                        int x = Integer.parseInt(String.valueOf(strings.get(0).charAt(2)));
                        int y = Integer.parseInt(String.valueOf(strings.get(0).charAt(1)));
                        if (mI == matrixIndex && x == xWertLokal && y == yWertLokal) {
                            if (Integer.parseInt(String.valueOf(strings.get(0).charAt(5))) == 0) {
                                // Delete cause for wrong cell - sub matrix
                                int lmI = Integer.parseInt(String.valueOf(strings.get(0).charAt(0)));
                                int li = Integer.parseInt(String.valueOf(strings.get(0).charAt(3)));
                                int ln = Integer.parseInt(String.valueOf(strings.get(0).charAt(4)));
                                board.get((lmI - 1)).getCell(li, ln).setCause(false);
                            }
                            if (Integer.parseInt(String.valueOf(strings.get(0).charAt(5))) == 1) {
                                // Delete cause for wrong cell - x-Axis
                                int lxp = Integer.parseInt(String.valueOf(strings.get(0).charAt(3)));
                                int ly = Integer.parseInt(String.valueOf(strings.get(0).charAt(1)));
                                int ln1 = Integer.parseInt(String.valueOf(strings.get(0).charAt(4)));
                                board.get((lxp - 1)).getCell((ly - 1), ln1).setCause(false);
                            }

                            if (strings.size() > 1) {
                                if (Integer.parseInt(String.valueOf(strings.get(1).charAt(5))) == 1) {
                                    // Delete cause for wrong cell - x-Axis
                                    int lxp = Integer.parseInt(String.valueOf(strings.get(1).charAt(3)));
                                    int ly = Integer.parseInt(String.valueOf(strings.get(1).charAt(1)));
                                    int ln1 = Integer.parseInt(String.valueOf(strings.get(1).charAt(4)));
                                    board.get((lxp - 1)).getCell((ly - 1), ln1).setCause(false);
                                }
                            }


                            if (Integer.parseInt(String.valueOf(strings.get(0).charAt(5))) == 2) {
                                // Delete cause for wrong cell - y-Axis
                                int lyp = Integer.parseInt(String.valueOf(strings.get(0).charAt(3)));
                                int lx = Integer.parseInt(String.valueOf(strings.get(0).charAt(2)));
                                int ln2 = Integer.parseInt(String.valueOf(strings.get(0).charAt(4)));
                                board.get((lyp - 1)).getCell(ln2, (lx - 1)).setCause(false);
                            }

                            if (strings.size() > 1) {
                                if (Integer.parseInt(String.valueOf(strings.get(1).charAt(5))) == 2) {
                                    // Delete cause for wrong cell - y-Axis
                                    int lyp = Integer.parseInt(String.valueOf(strings.get(1).charAt(3)));
                                    int lx = Integer.parseInt(String.valueOf(strings.get(1).charAt(2)));
                                    int ln2 = Integer.parseInt(String.valueOf(strings.get(1).charAt(4)));
                                    board.get((lyp - 1)).getCell(ln2, (lx - 1)).setCause(false);
                                }
                            }

                            if (strings.size() > 2) {
                                if (Integer.parseInt(String.valueOf(strings.get(2).charAt(5))) == 2) {
                                    // Delete cause for wrong cell - y-Axis
                                    int lyp = Integer.parseInt(String.valueOf(strings.get(2).charAt(3)));
                                    int lx = Integer.parseInt(String.valueOf(strings.get(2).charAt(2)));
                                    int ln2 = Integer.parseInt(String.valueOf(strings.get(2).charAt(4)));
                                    board.get((lyp - 1)).getCell(ln2, (lx - 1)).setCause(false);
                                }
                            }

                            strings.clear();
                        }
                    }
                }

                System.out.println("Fehler behoben");
            }
        } else {
            if (firstRun) {
                mistakes ++;
            }

            if (mistakes > mistakesMax) {
                if (mistakesMax != 0) {
                    System.out.println("Du hast die maximale Anzahl an Fehlern erreicht");
                    long endTime = System.currentTimeMillis();
                    lastGameTime = (endTime - startTime) / 60000;
                    System.out.println("Benötigte Zeit: " + lastGameTime + " min");
                    String[] args = {};
                    main(args);
                }
            }
        }

        if (checks > 0) { // Search the entire list of mistakes and validate them
            for (int i = 0; i < xyGlobalFalsch.size(); i++) {
                int mI = Integer.parseInt(String.valueOf(xyGlobalFalsch.get(0).charAt(0)));
                int x = Integer.parseInt(String.valueOf(xyGlobalFalsch.get(0).charAt(2)));
                int y = Integer.parseInt(String.valueOf(xyGlobalFalsch.get(0).charAt(1)));
                checks --;

                checkInput(mI, x, y, false);
            }
        }

        printSudoku();

        benutzerinteraktion();
    }
}