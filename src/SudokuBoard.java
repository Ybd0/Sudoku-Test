import java.util.ArrayList;

public class SudokuBoard extends ArrayList<Matrix> {

    // implement Singleton Pattern

    public SudokuBoard() {
        super();
    }

    /*

    public void print() {
        System.out.println("Sudoku Board");

        this.printFirstLine();
        System.out.println();
        this.printSecondLine();
        System.out.println();
        this.printThirdLine();
        System.out.println("\n---------------------------------");
        this.printFourthLine();
        System.out.println();
        this.printFifthLine();
        System.out.println();
        this.printSixthLine();
        System.out.println("\n---------------------------------");
        this.printSeventhLine();
        System.out.println();
        this.printEighthLine();
        System.out.println();
        this.printNinthLine();
        System.out.println('\n');
    }

    public void printFirstLine() {
        this.get(0).printFirstLine();
        System.out.print(" | ");
        this.get(1).printFirstLine();
        System.out.print(" | ");
        this.get(2).printFirstLine();
    }

    public void printSecondLine() {
        this.get(0).printSecondLine();
        System.out.print(" | ");
        this.get(1).printSecondLine();
        System.out.print(" | ");
        this.get(2).printSecondLine();
    }

    public void printThirdLine() {
        this.get(0).printThirdLine();
        System.out.print(" | ");
        this.get(1).printThirdLine();
        System.out.print(" | ");
        this.get(2).printThirdLine();
    }

    public void printFourthLine() {
        this.get(3).printFirstLine();
        System.out.print(" | ");
        this.get(4).printFirstLine();
        System.out.print(" | ");
        this.get(5).printFirstLine();
    }

    public void printFifthLine() {
        this.get(3).printSecondLine();
        System.out.print(" | ");
        this.get(4).printSecondLine();
        System.out.print(" | ");
        this.get(5).printSecondLine();
    }

    public void printSixthLine() {
        this.get(3).printThirdLine();
        System.out.print(" | ");
        this.get(4).printThirdLine();
        System.out.print(" | ");
        this.get(5).printThirdLine();
    }

    public void printSeventhLine() {
        this.get(6).printFirstLine();
        System.out.print(" | ");
        this.get(7).printFirstLine();
        System.out.print(" | ");
        this.get(8).printFirstLine();
    }

    public void printEighthLine() {
        this.get(6).printSecondLine();
        System.out.print(" | ");
        this.get(7).printSecondLine();
        System.out.print(" | ");
        this.get(8).printSecondLine();
    }

    public void printNinthLine() {
        this.get(6).printThirdLine();
        System.out.print(" | ");
        this.get(7).printThirdLine();
        System.out.print(" | ");
        this.get(8).printThirdLine();
    }

    public void printSubMatrix(final int index){
        this.get(index).print(index);
    }

     */

}