package ru.job4j.list;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;
//    @Test
//    public void whenPush123ThenPop123() {
//        queue = new SimpleQueue<>();
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        assertThat(queue.poll(), is(1));
//        assertThat(queue.poll(), is(2));
//        assertThat(queue.poll(), is(3));
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        assertThat(queue.poll(), is(1));
//        assertThat(queue.poll(), is(2));
//        assertThat(queue.poll(), is(3));
//        queue.push(1);
//        queue.push(2);
//        assertThat(queue.poll(), is(1));
//        assertThat(queue.poll(), is(2));
//        queue.push(3);
//        assertThat(queue.poll(), is(3));
//    }

}