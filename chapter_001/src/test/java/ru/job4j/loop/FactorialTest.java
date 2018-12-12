package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void whenFiveThenFactorialOneHundredTwenty() {
        Factorial factorial = new Factorial();
        int n = 5;
        int expect = 120;
        int result = factorial.calc(n);
        assertThat(expect, is(result));
    }

    @Test
    public void whenZeroThenFactorialOne() {
        Factorial factorial = new Factorial();
        int n = 0;
        int expect = 1;
        int result = factorial.calc(n);
        assertThat(expect, is(result));
    }

}