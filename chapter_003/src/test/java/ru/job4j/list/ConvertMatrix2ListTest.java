package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when0on0ArrayThenList0() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {},
                {}
        };
        List<Integer> expect = Arrays.asList();
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when1on0ArrayThenList0() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1},
                {}
        };
        List<Integer> expect = Arrays.asList(1);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenListWith2Arrays2Plus4ThenList6() {
        ConvertMatrix2List convertList = new ConvertMatrix2List();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        expect.add(5);
        expect.add(6);
        List<Integer> result = convertList.convert(list);
        assertThat(result, is(expect));
    }
}