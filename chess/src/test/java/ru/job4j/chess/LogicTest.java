package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KnightBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test (expected = OccupiedWayException.class)
    public void whenBishopMoveFromD8ToA5AndB6IsNotEmptyThenOccupiedWayException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        KnightBlack knightBlack = new KnightBlack(Cell.A5);
        logic.add(bishopBlack);
        logic.add(knightBlack);
        logic.move(Cell.D8, Cell.A5);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenBishopMoveFromD8ToA6AndB6IsNotEmptyThenImpossibleMoveException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        KnightBlack knightBlack = new KnightBlack(Cell.A5);
        logic.add(bishopBlack);
        logic.add(knightBlack);
        logic.move(Cell.D8, Cell.A6);
    }
    @Test (expected = FigureNotFoundException.class)
    public void whenMoveFigureFromD7ToA6AThenFigureNotFoundException() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.D8);
        KnightBlack knightBlack = new KnightBlack(Cell.A5);
        logic.add(bishopBlack);
        logic.add(knightBlack);
        logic.move(Cell.D7, Cell.A6);
    }

    @Test
    public void whenKnightFromC3ToE2ThenTrue() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        Cell source = Cell.C3;
        Cell dest = Cell.E2;
        logic.add(new KnightBlack(source));
        boolean expected = true;
        boolean result = logic.move(source, dest);
        assertThat(result, is(expected));
    }

}