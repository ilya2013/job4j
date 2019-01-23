package ru.job4j;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class ControlTaskTest {

    @Test
    public void merge1() {
        int[] a = new int[]{3, 7, 8, 9, 13};
        int[] b = new int[]{1, 3, 5, 7, 10};
        int[] expected = new int[] {1, 3, 3, 5, 7, 7, 8, 9, 10, 13};
        ControlTask controlTask = new ControlTask();
        int[] result = controlTask.merge(a, b);
        assertThat(result, is(expected));
    }

    @Test
    public void merge2() {
        int[] a = new int[]{3, 7, 8, 9, 10};
        int[] b = new int[]{1, 3, 5, 7, 13};
        int[] expected = new int[] {1, 3, 3, 5, 7, 7, 8, 9, 10, 13};
        ControlTask controlTask = new ControlTask();
        int[] result = controlTask.merge(a, b);
        assertThat(result, is(expected));
    }

        @Test
    public void merge3() {
        int[] a = new int[]{9, 13};
        int[] b = new int[]{7, 10};
        int[] expected = new int[] { 7, 9, 10, 13};
        ControlTask controlTask = new ControlTask();
        int[] result = controlTask.merge(a, b);
        assertThat(result, is(expected));
    }

    @Test
    public void merge4() {
        int[] a = new int[]{3, 10};
        int[] b = new int[]{1, 13};
        int[] expected = new int[] {1, 3, 10, 13};
        ControlTask controlTask = new ControlTask();
        int[] result = controlTask.merge(a, b);
        assertThat(result, is(expected));
    }

}