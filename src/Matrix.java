

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
            System.out.print(' ' + this.get(0).get(i).getValue().toString() + ' ');
        }
    }

    public void printSecondLine() {
        for (int i = 0; i < 3; i++) {
            System.out.print(' ' + this.get(1).get(i).getValue().toString() + ' ');
        }
    }

    public void printThirdLine() {
        for (int i = 0; i < 3; i++) {
            System.out.print(' ' + this.get(2).get(i).getValue().toString() + ' ');
        }
    }

}
