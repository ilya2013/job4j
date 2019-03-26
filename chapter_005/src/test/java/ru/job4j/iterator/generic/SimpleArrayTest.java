package ru.job4j.iterator.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void whenGetUnexistingElementThenGetNull() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(10);
        Integer expected = null;
        Integer result = simpleArray.get(1);
        assertThat(result, is(expected));
    }

    @Test
    public void whenEditUnexitingElementthenFalse() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(10);
        boolean expected = false;
        boolean result = simpleArray.set(1, 10);
        assertThat(result, is(expected));
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

//    @Test
//    public void whenAddIteratorThenGet10() throws TooManyElements {
//        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
//        simpleArray.add(10);
//        simpleArray.add(11);
//        for (Integer e : simpleArray) {
//            System.out.println(e);
//        }
//    }

    @Test
    public void when() throws TooManyElements {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4) ;
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
}