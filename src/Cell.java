public class Cell {
    private Integer value;
    private boolean wrong = false;
    private final boolean changeable;

    public Cell(int value) {
        this.value = value;
        this.changeable = value == 0;
    }

    public Integer getValue() {
        return value;
    }

    public boolean isWrong() {
        return wrong;
    }

    public boolean isChangeable() {
        return changeable;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setWrong(boolean wrong) {
        this.wrong = wrong;
    }
}