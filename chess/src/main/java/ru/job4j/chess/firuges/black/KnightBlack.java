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
public class KnightBlack extends BasicFigure {
    public KnightBlack(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int stepsCount = 0;
        Cell[] result;
        if (isG(source, dest)) {
            stepsCount = 3;
            int deltaX = source.x > dest.x ? -1  : 1;
            int deltaY = source.y > dest.y ? -1  : 1;
            if (Math.abs(dest.x - source.x) == 2) {
                result = new Cell[] {super.findBy(source.x + deltaX, source.y),
                        super.findBy(source.x + deltaX * 2, source.y),
                        super.findBy(source.x + deltaX * 2, source.y + deltaY)};
            } else {
                result = new Cell[] {super.findBy(source.x, source.y + deltaY),
                    super.findBy(source.x, source.y + deltaY * 2),
                    super.findBy(source.x + 1, source.y + deltaY * 2)};
            }

        } else {
            throw new ImpossibleMoveException();
        }
        return result;
    }

    protected boolean isG(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
