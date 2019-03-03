package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


import static org.junit.Assert.*;

public class FlatMapTaskTest {

    @Test
    public void convert2x2() {
        Integer[][] matrix = {{2, 7}, {3, 6}};
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(7);
        expected.add(3);
        expected.add(6);
        List<Integer> result = new FlatMapTask().convert(matrix);
        assertThat(result, is(expected));
    }
}