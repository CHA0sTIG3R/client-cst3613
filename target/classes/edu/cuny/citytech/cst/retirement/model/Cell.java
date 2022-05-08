package edu.cuny.citytech.cst.retirement.model;

public class Cell {
    private int position;
    private String value = "N";
    private String displayValue = "";

    public Cell() {
    }

    public Cell(int position, String value, String displayValue) {
        this.position = position;
        this.value = value;
        this.displayValue = displayValue;
    }

    public Cell(int position) {
        this.position = position;
        this.displayValue = "N" + position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "position=" + position +
                ", value='" + value + '\'' +
                ", displayValue='" + displayValue + '\'' +
                '}';
    }
}
