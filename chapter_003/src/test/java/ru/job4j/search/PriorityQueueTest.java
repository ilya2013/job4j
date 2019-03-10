package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriority2() {
        var queue = new PriorityQueue();
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 5));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriority3() {
        var queue = new PriorityQueue();
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenMiddlePriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 5));
        Task result = queue.take();
        result = queue.take();
        assertThat(result.getDesc(), is("middle"));
    }
    @Test
    public void whenUrgentPriority4() {
        var queue = new PriorityQueue();
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 5));
        Task result = queue.take();
        result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
    @Test
    public void whenLowPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 5));
        Task result = queue.take();
        result = queue.take();
        result = queue.take();
        result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }
}