package ru.job4j.pseudo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class TriangleTest {

    @Test
    public void whenDrawThenTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(new StringBuilder()
                        .append("  +  \n")
                        .append(" +++ \n")
                        .append("+++++")
                        .toString()
                )
        );
    }

}