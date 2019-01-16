package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

//    public boolean isWin() {
//        int[][] table = this.convert();
////        boolean colWin = true;
////        boolean rowWin = true;
//        boolean result = false;
////        for (int i = 0; i < this.size; i++) {
//            //Поиск столбца и сточки на проверку
//            if (table[i][i] == 1) {
//                //Проверка строчки
//                for (int col = 0; col < this.size; col++) {
//                    colWin &= (table[i][col] == 1);
//                    if (!colWin) {
//                        break;
//                    }
//                }
//                //Проверка столбца
//                if (!colWin) {
//                    for (int row = 0; row < this.size; row++) {
//                        rowWin &= (table[row][i] == 1);
//                        if (!rowWin) {
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        if (rowWin || colWin) {
//            result = true;
//        }


//        return result;
//    }

    public boolean isWin() {
        boolean result;
        long start;
        long finish;
        start = System.currentTimeMillis();
        result = isWinMy();
        finish = System.currentTimeMillis();
        System.out.println(finish - start);

        start = System.currentTimeMillis();
        result = isWinRecomendent();
        finish = System.currentTimeMillis();
        System.out.println(finish - start);
        return result;
    }

    public boolean isWinMy() {
        int[][] table = this.convert();
        int checkRow = -1;
        int checkCol = -1;
        int iterCount = 0;
        boolean result = false;
        for (int i = 0; i < this.size; i++) {
            iterCount++;
            //Поиск столбца и сточки на проверку
            if (table[i][i] == 1) {
                //Строки проверку
                for (int col = 0; col < this.size; col++) {
                    iterCount++;
                    if (table[i][col] == 1) {
                        checkRow = col;
                    } else {
                        break;
                    }
                }
                //Проверка столбца
                if (checkRow < 1) {
                    for (int row = 0; row < this.size; row++) {
                        iterCount++;
                        if (table[row][i] == 1) {
                            checkCol = row;
                        } else {
                            break;
                        }
                    }
                }
                if ((checkRow == this.size - 1) || (checkCol == this.size - 1)) {
                    result = true;
                    break;
                }
            }
        }
        System.out.format("Кол-во итераций в методе isWinMy: %s%s", iterCount, System.lineSeparator());
        return result;
    }

    public boolean isWinRecomendent() {
        int[][] table = this.convert();
        int checkRow;
        int checkCol;
        int iterCount = 0;
        boolean result = false;
        for (int i = 0; i < this.size; i++) {
            checkRow = 0;
            checkCol = 0;
            for (int j = 0; j < this.size; j++) {
                if (table[i][j] == 1) {
                    checkRow++;
                }
                if (table[j][i] == 1) {
                    checkCol++;
                }
                iterCount++;
            }
            if ((checkCol == this.size) || (checkRow == this.size)) {
                result = true;
                break;
            }
        }
        System.out.format("Кол-во итераций в методе isWinRecomendent: %s%s", iterCount, System.lineSeparator());
        return result;
    }


    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
