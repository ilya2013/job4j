package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayContainerTest {

    @Test
    public void whenAddElementContainerDoubleItself() {
        DynamicArrayContainer<Integer> arrayContainer = new DynamicArrayContainer<>(2);
        arrayContainer.add(1);
        arrayContainer.add(2);
        arrayContainer.add(3);
        assertThat(arrayContainer.get(2), is(3));
        arrayContainer.add(4);
        arrayContainer.add(5);
        assertThat(arrayContainer.get(4), is(5));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenWhileIterateAddElementThenConcurrentModificationException() {
        DynamicArrayContainer<Integer> arrayContainer = new DynamicArrayContainer<>(2);
        arrayContainer.add(1);
        arrayContainer.add(2);
        Iterator<Integer> iterator = arrayContainer.iterator();
        iterator.next();
        arrayContainer.add(2);
        iterator.next();
    }


}