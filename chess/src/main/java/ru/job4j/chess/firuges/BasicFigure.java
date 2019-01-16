package ru.job4j.chess.firuges;

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
    abstract public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    @Override
    abstract public Figure copy(Cell dest);
}
