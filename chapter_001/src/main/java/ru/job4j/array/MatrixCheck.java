package ru.job4j.array;


public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int rowsCount = data.length;

        boolean firstDiagonal = data[0][0];
        boolean secondDiagonal = data[rowsCount- 1][0];

        for (int rowIdx = 0; rowIdx < rowsCount; rowIdx++) {
            if ((firstDiagonal != data [rowIdx] [rowIdx]) || (secondDiagonal != data [rowsCount - 1 - rowIdx] [rowsCount - 1 - rowIdx])) {
                result = false;
            }
        }
        return result;
    }
}