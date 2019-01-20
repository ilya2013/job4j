package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.BasicFigure;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends BasicFigure {
    public  BishopBlack(Cell cell) {
        super(cell);
    }
    @Override
    public Cell position() {
       return super.position();
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int stepsCount = 0;
        Cell[] result = new Cell[8];
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException();
        } else {
            int deltaX = source.x > dest.x ? -1  : 1;
            int deltaY = source.y > dest.y ? -1  : 1;
            for (int idx = 0; idx < Math.abs(dest.x - source.x); idx++) {
                result [idx] = super.findBy(source.x + deltaX * (idx + 1), source.y  + deltaY * (idx + 1));
                stepsCount++;
            }
        }
        return Arrays.copyOf(result, stepsCount);
    }


     protected boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            result = true;
        }
        return result;
    }


    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
