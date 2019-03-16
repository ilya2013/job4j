package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
public class ControlTaskTest {

    @Test
    public void convertTest() {
        List<Integer> list = List.of(1, 2, 3, 4);
        int expected = 20;
        var controlTask = new ControlTask();
        assertThat(controlTask.convert(list), is(expected));
    }

    @Test
    public void convertNullTest() {
        List<Integer> list = Arrays.asList(1, null, 3, 4);
        int expected = 16;
        var controlTask = new ControlTask();
        assertThat(controlTask.convert(list), is(expected));
    }
    @Test
    public void convertNullListTest() {
        List<Integer> list = Arrays.asList();
        int expected = 0;
        var controlTask = new ControlTask();
        assertThat(controlTask.convert(list), is(expected));
    }


}