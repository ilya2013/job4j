package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KnightBlackTest {

    @Test
    public void whenFromC3ToD1ThenTrue() {
        Cell source = Cell.C3;
        Cell dest = Cell.D1;
        KnightBlack knightBlack = new KnightBlack(source);
        boolean expected = true;
        boolean result = knightBlack.isG(source, dest);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFromC3ToA3ThenFalse() {
        Cell source = Cell.C3;
        Cell dest = Cell.A3;
        KnightBlack knightBlack = new KnightBlack(source);
        boolean expected = false;
        boolean result = knightBlack.isG(source, dest);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFromC3ToD6ThenFalse() {
        Cell source = Cell.C3;
        Cell dest = Cell.D6;
        KnightBlack knightBlack = new KnightBlack(source);
        boolean expected = false;
        boolean result = knightBlack.isG(source, dest);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFromC3ToE2ThenTrue() {
        Cell source = Cell.C3;
        Cell dest = Cell.E2;
        KnightBlack knightBlack = new KnightBlack(source);
        boolean expected = true;
        boolean result = knightBlack.isG(source, dest);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFromC3ToA4ThenB3A3A4() throws ImpossibleMoveException {
        Cell source = Cell.C3;
        Cell dest = Cell.A4;
        KnightBlack knightBlack = new KnightBlack(source);
        Cell[] expected = {Cell.B3, Cell.A3, Cell.A4};
        Cell[] result = knightBlack.way(source, dest);
        assertThat(result, is(expected));
    }

}