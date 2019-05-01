package ru.job4j;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);

    @Test
    public void ifHasCycleInTheEndThen() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(Node.hasCycle(first), is(true));
    }
    @Test
    public void ifHasCycleInTheMiddleThenTrue() {
    first.next = two;
    two.next = first;
    third.next = four;
    four.next = null;
    assertThat(Node.hasCycle(first), is(true));
}
    @Test
    public void ifHasNoCycleThen() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(Node.hasCycle(first), is(false));
    }

}