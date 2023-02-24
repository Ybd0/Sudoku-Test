public class GererateSudoku {
    static int[] test1 = new int[9];
    static int[] test2 = new int[9];
    static int[] test3 = new int[9];
    static int[] test4 = new int[9];
    static int[] test5 = new int[9];
    static int[] test6 = new int[9];
    static int[] test7 = new int[9];
    static int[] test8 = new int[9];
    static int[] test9 = new int[9];

    static int[][] testAll;
    static int[][] testBoard = new int[9][9];
    public static void fillArray() {

        test1 = Main.Matrix1;
        test2 = Main.Matrix2;
        test3 = Main.Matrix3;
        test4 = Main.Matrix4;
        test5 = Main.Matrix5;
        test6 = Main.Matrix6;
        test7 = Main.Matrix7;
        test8 = Main.Matrix8;
        test9 = Main.Matrix9;

        testAll = new int[][]{test1, test2, test3, test4, test5, test6, test7, test8, test9};


        System.out.println("Hier");
        for (int i = 0; i < 9; i++) {

            System.out.println(testAll[0][i]);
        }


        // von array als 3x3-Matrix Form zu array als Zeile Form konvertieren

        convertArrays();


        // konvertierte Form in die Arrays schreiben

        for (int i = 0; i < 9; i++) {
            System.arraycopy(testBoard[i], 0, testAll[i], 0, 9);
        }

        shiftArrays();
    }

    private static void convertArrays() {
        int prAid = 0;

        for (int i = 0; i < 9; i++) {
            int boardIndex = 0;

            for (int n = 0; n < 3; n++) {
                for (int o = 0; o < 3; o++) {
                    testBoard[i][boardIndex] = testAll[(n + ((i / 3) * 3))][o + prAid * 3];
                    boardIndex ++;
                }
            }

            prAid ++;
            if (prAid == 3) {
                prAid = 0;
            }
        }
    }

    public static void shiftArrays() {

        // array in zeilen - Form 3 bzw 6 nach rechts rücken

        int firstNumber;

        int shiftAmount = 0;

        for (int o = 1; o < 9; o++){


            if (shiftAmount == 4 || shiftAmount == 11) {
                shiftAmount = shiftAmount + 2;
                shiftAmount++;
            } else {
                shiftAmount = shiftAmount + 2;
            }

            for (int n = 0; n < shiftAmount; n++) {

                firstNumber = testAll[o][0];

                for (int i = 0; i < 8; i++) {

                    testAll[o][i] = testAll[o][(i + 1)];

                }
                testAll[o][testAll[0].length - 1] = firstNumber;

            }


        }

        // arrays von zeilenform in 3x3 - Matrix - Form wieder umwandeln

        convertArrays();

        for (int i = 0; i < 9; i++) {
            System.arraycopy(testBoard[i], 0, testAll[i], 0, 9);
        }

        // Ergebnisse printen

        for (int o = 0; o < 9; o++) {
            System.out.println("Zeile " + o);
            for (int i = 0; i < 9; i++) {

                System.out.println(testAll[o][i]);
            }
        }



        System.out.println("testBoard");

        for (int i = 0; i < 9; i++) {
            System.out.println("Zeile " + i);
            for (int n = 0; n < 9; n++) {
                System.out.println(testBoard[i][n]);
            }
        }


    }
}