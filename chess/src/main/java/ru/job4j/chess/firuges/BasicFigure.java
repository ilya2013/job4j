package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

public abstract class BasicFigure implements Figure {
    protected final Cell position;

    protected BasicFigure(Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return position;
    }
    @Override
    abstract public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    protected Cell findBy(double cellX, double cellY) {
        Cell rst = Cell.A1;
        for (Cell cell : Cell.values()) {
            if ((cell.x ==cellX) && (cell.y == cellY)) {
                rst = cell;
                break;
            }
        }
        return rst;
    }
}
