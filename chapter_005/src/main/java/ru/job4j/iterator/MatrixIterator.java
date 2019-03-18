package ru.job4j.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator {
    private final int[][] matrix;
    private int rowId = 0;
    private int colId = 0;


    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return rowId < matrix.length;
    }

    @Override
    public Integer next() {
        int result = matrix[rowId][colId];
        if (colId == matrix[rowId].length - 1) {
            rowId++;
            colId = 0;
        } else {
            colId++;
        }
        return result;
    }
}
