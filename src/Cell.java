public class Cell {
    private Integer value;
    private final boolean changeable;

    public Cell(int value) {
        this.value = value;
        this.changeable = value != 0;
    }

    public Integer getValue() {
        return value;
    }

    public boolean isChangeable() {
        return changeable;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}