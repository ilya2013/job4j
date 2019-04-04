package ru.job4j.list;


import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class SimpleStackTest {
    private SimpleStack<Integer> list;
    @Test
    public void whenPush123ThenPop321() {
        list = new SimpleStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        assertThat(list.poll(), is(3));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(1));
    }
}