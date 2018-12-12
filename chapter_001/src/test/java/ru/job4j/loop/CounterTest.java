package ru.job4j.loop;

import org.junit.Test;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int start = 0;
        int finish = 10;
        int expect = 30;
        int result = counter.add(start, finish);
        assertThat(expect, is(result));
    }
}