package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        Integer result = list.delete();
        Integer expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenWhileIterateAddElementThenGetConcurrentModificationException() {
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        list.add(4);
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test (expected = NoSuchElementException.class)
    public void whenWhileIterateAddElementThenGetConcurrentModificationExceptin() {
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}