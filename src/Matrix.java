

import java.util.ArrayList;

public class Matrix extends ArrayList<ArrayList<Cell>>{

    public Matrix() {
        super();
    }

    public Cell getCell(int row, int col) {
        return this.get(row).get(col);
    }


    protected void print(final int index) {
        System.out.println("Sub Matrix " + index + ": ");

        for (ArrayList<Cell> row : this) {
            for (Cell cell : row) {
                System.out.print(' ' + cell.getValue().toString() + ' ');
            }
            System.out.println();
        }
    }

    public void printFirstLine() {
        for (int i = 0; i < 3; i++) {
            if (this.get(0).get(i).getValue() == 0) { // Print blue "?" if value is Zero
                System.out.print((char) 27 + "[34m ? ");
                System.out.print((char) 27 + "[0m");
            } else if (this.get(0).get(i).isChangeable() && this.get(0).get(i).getValue() != 0) { // Print turquoise if number is changeable
                System.out.print((char) 27 + "[33m" + ' ' + this.get(0).get(i).getValue().toString() + ' ');
                System.out.print((char) 27 + "[0m");
            } else {
                System.out.print(' ' + this.get(0).get(i).getValue().toString() + ' '); // Print number white if it is not changeable
            }
        }
    }

    public void printSecondLine() {
        for (int i = 0; i < 3; i++) {
            if (this.get(1).get(i).getValue() == 0) {
                System.out.print((char) 27 + "[34m ? ");
                System.out.print((char) 27 + "[0m");
            } else if (this.get(1).get(i).isChangeable() && this.get(1).get(i).getValue() != 0) {
                System.out.print((char) 27 + "[33m" + ' ' + this.get(1).get(i).getValue().toString() + ' ');
                System.out.print((char) 27 + "[0m");
            } else {
                System.out.print(' ' + this.get(1).get(i).getValue().toString() + ' ');
            }
        }
    }

    public void printThirdLine() {
        for (int i = 0; i < 3; i++) {
            if (this.get(2).get(i).getValue() == 0) {
                System.out.print((char) 27 + "[34m ? ");
                System.out.print((char) 27 + "[0m");
            } else if (this.get(2).get(i).isChangeable() && this.get(2).get(i).getValue() != 0) {
                System.out.print((char) 27 + "[33m" + ' ' + this.get(2).get(i).getValue().toString() + ' ');
                System.out.print((char) 27 + "[0m");
            } else {
                System.out.print(' ' + this.get(2).get(i).getValue().toString() + ' ');
            }
        }
    }

}