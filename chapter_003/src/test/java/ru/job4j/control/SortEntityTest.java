package ru.job4j.control;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortEntityTest {
    /**
     * Тест на сортировку по возрастанию.
     */
    @Test
    public void whenSortDepsAsc() {
        List deps = Arrays.asList(
                new Department("K1\\SK1"),
                new Department("K1\\SK2"),
                new Department("K1\\SK1\\SSK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K2"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K2\\SK1\\SSK2")
        );
        SortEntity sortDepartment = new SortEntity();
        List result = sortDepartment.sortDepartmentsAsc(deps);
        List expect = Arrays.asList(
                new Department("K1"),
                new Department("K1\\SK1"),
                new Department("K1\\SK1\\SSK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K1\\SK2"),
                new Department("K2"),
                new Department("K2\\SK1"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K2\\SK1\\SSK2")
        );
        assertThat(result, is(expect));
    }

    /**
     * Тест на сортировку по убыванию.
     */
    @Test
    public void whenSortDepsDesc() {
        List deps = Arrays.asList(
                new Department("K1\\SK1"),
                new Department("K1\\SK2"),
                new Department("K1\\SK1\\SSK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K2"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K2\\SK1\\SSK2")
        );
        SortEntity sortDepartment = new SortEntity();
        List result = sortDepartment.sortDepartmentsDesc(deps);
        List expect = Arrays.asList(
                new Department("K2"),
                new Department("K2\\SK1"),
                new Department("K2\\SK1\\SSK2"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K1"),
                new Department("K1\\SK2"),
                new Department("K1\\SK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K1\\SK1\\SSK1")
        );
        assertThat(result, is(expect));
    }

}