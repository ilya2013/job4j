package ru.job4j.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAdd10ThenGet10() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(10);
        int expected = 10;
        int result = simpleArray.get(0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetUnexistingElementThenGetNull() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(10);
        Integer expected = null;
        Integer result = simpleArray.get(1);
        assertThat(result, is(expected));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenEditUnexitingElementthenFalse()  {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(10);
        simpleArray.set(1, 10);
    }

    @Test
    public void whenEditUnexistingElementThenGetNull() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        Integer expected = 11;
        simpleArray.add(10);
        simpleArray.set(0, 11);
        Integer result = simpleArray.get(0);
        assertThat(result, is(expected));
    }

    @Test
    public void when() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        List<Integer> result = new ArrayList<>();
        List<Integer> expected = List.of(11, 12);
        simpleArray.add(10);
        simpleArray.add(11);
        simpleArray.add(12);
        simpleArray.remove(0);
        for (Integer e : simpleArray) {
            result.add(e);
        }
        assertThat(result, is(expected));
    }

    @Test
    public void whenRemoveLastElement() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        List<Integer> result = new ArrayList<>();
        List<Integer> expected = List.of(10, 11);
        simpleArray.add(10);
        simpleArray.add(11);
        simpleArray.add(12);
        simpleArray.remove(2);
        for (Integer e : simpleArray) {
            result.add(e);
        }
        assertThat(result, is(expected));
    }

    @Test
    public void whenMiddleLastElement() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        List<Integer> result = new ArrayList<>();
        List<Integer> expected = List.of(10, 12);
        simpleArray.add(10);
        simpleArray.add(11);
        simpleArray.add(12);
        simpleArray.remove(1);
        for (Integer e : simpleArray) {
            result.add(e);
        }
        assertThat(result, is(expected));
    }
}