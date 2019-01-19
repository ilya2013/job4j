package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BishopBlackTest {

    @Test
    public void whenFromB1ToD3ThenTrue() {
        Cell source = Cell.B1;
        Cell dest = Cell.D3;
        BishopBlack bishopBlack = new BishopBlack(source);
        boolean expected = true;
        boolean result;
        result = bishopBlack.isDiagonal(source, dest);
        assertThat(expected, is(result));
    }

    @Test
    public void whenFromB1ToB2ThenFalse() {
        Cell source = Cell.B1;
        Cell dest = Cell.B2;
        BishopBlack bishopBlack = new BishopBlack(source);
        boolean expected = false;
        boolean result;
        result = bishopBlack.isDiagonal(source, dest);
        assertThat(expected, is(result));
    }

    @Test
    public void whenFromD4ToA1ThenTrue() {
        Cell source = Cell.D4;
        Cell dest = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(source);
        boolean expected = true;
        boolean result;
        result = bishopBlack.isDiagonal(source, dest);
        assertThat(expected, is(result));
    }

    @Test
    public void whenFromD4ToA7ThenTrue() {
        Cell source = Cell.D4;
        Cell dest = Cell.A7;
        BishopBlack bishopBlack = new BishopBlack(source);
        boolean expected = true;
        boolean result;
        result = bishopBlack.isDiagonal(source, dest);
        assertThat(expected, is(result));
    }
    @Test
    public void whenFromD4ToA8ThenFalse() {
        Cell source = Cell.D4;
        Cell dest = Cell.A8;
        BishopBlack bishopBlack = new BishopBlack(source);
        boolean expected = false;
        boolean result;
        result = bishopBlack.isDiagonal(source, dest);
        assertThat(expected, is(result));
    }

    @Test
    public void whenWayFromB2ToD4ThenC3D4() throws ImpossibleMoveException {
        Cell source = Cell.B2;
        Cell dest = Cell.D4;
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] expected = new Cell[2];
        expected[0] = Cell.C3;
        expected[1] = Cell.D4;
        Cell[] result = bishopBlack.way(source, dest);
        assertThat(result, is(expected));
    }

    @Test
    public void whenWayFromB3ToA2ThenA3() throws ImpossibleMoveException {
        Cell source = Cell.B2;
        Cell dest = Cell.A3;
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] expected = new Cell[1];
        expected[0] = Cell.A3;
        Cell[] result = bishopBlack.way(source, dest);
        assertThat(result, is(expected));
    }

    @Test
    public void whenWayFromB3ToB3ThenA3() throws ImpossibleMoveException {
        Cell source = Cell.B3;
        Cell dest = Cell.B3;
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[] expected = new Cell[0];
        //expected[0] = Cell.B3;
        Cell[] result = bishopBlack.way(source, dest);
        assertThat(result, is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveSoThenImpossibleMoveException() throws ImpossibleMoveException {
        Cell source = Cell.B2;
        Cell dest = Cell.D3;
        BishopBlack bishopBlack = new BishopBlack(source);
        bishopBlack.way(source, dest);

    }

//    @Rule
//    public ExpectedException exceptionRule = ExpectedException.none();
//
//    @Test
//    public void whenExceptionThrown_thenRuleIsApplied() {
//        exceptionRule.expect(NumberFormatException.class);
//        exceptionRule.expectMessage("For input string");
//        Integer.parseInt("1a");
//    }
}