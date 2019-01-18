package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic extends Board{

    @Override
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        try {
            rst = super.move(source, dest);
        } catch (FigureNotFoundException e) {
            System.out.println("Фигура не найдена.");
        } catch (OccupiedWayException e) {
            System.out.println("Фигура на пути.");
        } catch (ImpossibleMoveException e) {
            System.out.format("Фигура не может так ходить.%s",System.lineSeparator());
        }
        return rst;
    }
}
