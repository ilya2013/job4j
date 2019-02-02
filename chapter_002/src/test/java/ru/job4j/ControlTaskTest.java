package ru.job4j;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ControlTaskTest {

    @Test
    public void changes() {
       ControlTask controlTask = new ControlTask();
       int[] reslut = controlTask.changes(2000, 35);
        System.out.println(Arrays.toString(reslut));
    }
}