package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PaintTest {

    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^")
                .toString();
        System.out.println(expected);
        assertThat(rst, is(expected));
    }
}