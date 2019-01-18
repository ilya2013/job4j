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
        int idx = 0;
        Cell[] result = new Cell[10];
        int positionX = source.x;
        int positionY = source.y;

        if (isDiagonal(source, dest)) {
            int deltaX = 1;
            int deltaY = 1;
            deltaX = source.x > dest.x ? -1 * deltaX : deltaX;
            deltaY = source.y > dest.y ? -1 * deltaY : deltaY;
            do {
                positionX += deltaX;
                positionY += deltaY;
                for (Cell cell : Cell.values()) {
                    if ((cell.x == positionX) && (cell.y == positionY)) {
                        result[idx] = cell;
                        idx++;
                        break;
                    }
                }
            } while (!(positionX == dest.x && positionY == dest.y));

//            System.out.println(source.name());
        } else {
            throw new ImpossibleMoveException();
        }

        return Arrays.copyOf(result, idx);
    }


     protected boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (isThisDiagonal(source, dest, 1, 1)
                || isThisDiagonal(source, dest, 1, -1)
                || isThisDiagonal(source, dest, -1, -1)
                || isThisDiagonal(source, dest, -1, 1)) {
            result = true;
        }
        return result;
    }
    private boolean isThisDiagonal(Cell source, Cell dest, int deltaX, int deltaY) {
        int sourceX = source.x;
        int sourceY = source.y;
        int destX = dest.x;
        int destY = dest.y;
        int size = 8;
        boolean result = false;
        for (int i = 0; i < size; i++) {
            sourceX += deltaX;
            sourceY += deltaY;
            if (destX == sourceX && destY == sourceY) {
                result = true;
            }
        }
        return result;
    }


    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
