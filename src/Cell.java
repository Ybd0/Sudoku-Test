public class Cell {
    private Integer value;
    private boolean wrong = false;
    private boolean cause = false;
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

    public boolean isCause() {
        return cause;
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

    public void setCause(boolean casue) {
        this.cause = casue;
    }
}