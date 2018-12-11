package ru.job4j.max;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenThreeMax() {
        Max maxim = new Max();
        int result = maxim.max(3, 1, 3);
        assertThat(result, is(3));
    }
}