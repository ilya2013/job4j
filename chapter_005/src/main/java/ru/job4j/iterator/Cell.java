package ru.job4j.iterator;

public class Cell {
    private int rowId = -1;
    private int colId = -1;


    public Cell(int rowId, int colId) {
        this.rowId = rowId;
        this.colId = colId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public void setColId(int colId) {
        this.colId = colId;
    }
}
