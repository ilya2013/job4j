package ru.job4j;

import static org.hamcrest.core.Is.is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void ifHasCycleThen() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(Node.hasCycle(first), is(true));
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(Node.hasCycle(first), is(false));
        first.next = two;
        two.next = first;
        third.next = four;
        four.next = null;
        assertThat(Node.hasCycle(first), is(true));
    }

}