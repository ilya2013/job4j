package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public abstract class Board {
    protected final Figure[] figures = new Figure[32];
    private int index = 0;

    protected void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    protected boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (steps.length == 0 ) {
            throw new ImpossibleMoveException();
        }
        for (Cell step : steps) {
            if (this.findBy(step) != -1/* && !steps[steps.length - 1].equals(dest)*/) {
                throw new OccupiedWayException();
            }
        }

        rst = true;
        this.figures[index] = this.figures[index].copy(dest);
        return rst;
    }

    protected void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    protected int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
