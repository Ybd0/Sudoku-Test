public class Cell {
    private int value;
    private final boolean changeable;

    public Cell(int value) {
        this.value = value;
        this.changeable = value == 0;
    }

    public int getValue() {
        return value;
    }

    public boolean isChangable() {
        return changeable;
    }

    public void setValue(int value) {
        this.value = value;
    }

}