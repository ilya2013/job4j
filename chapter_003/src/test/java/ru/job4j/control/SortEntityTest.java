package ru.job4j.control;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortEntityTest {
    /**
     * Тест на сортировку по возрастанию.
     */
    @Test
    public void whenSortDepsAsc() {
        List deps = Arrays.asList(
                new Entity("K1\\SK1"),
                new Entity("K1\\SK2"),
                new Entity("K1\\SK1\\SSK1"),
                new Entity("K1\\SK1\\SSK2"),
                new Entity("K2"),
                new Entity("K2\\SK1\\SSK1"),
                new Entity("K2\\SK1\\SSK2")
        );
        SortEntity sortAscDepartment = new SortEntity();
        sortAscDepartment.addElements(deps);
        List expect = Arrays.asList(
                new Entity("K1"),
                new Entity("K1\\SK1"),
                new Entity("K1\\SK1\\SSK1"),
                new Entity("K1\\SK1\\SSK2"),
                new Entity("K1\\SK2"),
                new Entity("K2"),
                new Entity("K2\\SK1"),
                new Entity("K2\\SK1\\SSK1"),
                new Entity("K2\\SK1\\SSK2")
        );
        assertThat(sortAscDepartment.getEntity().toArray(), is(expect.toArray()));
    }

    /**
     * Тест на сортировку по убыванию.
     */
    @Test
    public void whenSortDepsDesc() {
        List deps = Arrays.asList(
                new Entity("K1\\SK1"),
                new Entity("K1\\SK2"),
                new Entity("K1\\SK1\\SSK1"),
                new Entity("K1\\SK1\\SSK2"),
                new Entity("K2"),
                new Entity("K2\\SK1\\SSK1"),
                new Entity("K2\\SK1\\SSK2")
        );
        SortEntity sortDepartment = new SortEntity();
        sortDepartment.addElements(deps);
        List result = sortDepartment.sortDepartmentsDesc();
        List expect = Arrays.asList(
                new Entity("K2"),
                new Entity("K2\\SK1"),
                new Entity("K2\\SK1\\SSK2"),
                new Entity("K2\\SK1\\SSK1"),
                new Entity("K1"),
                new Entity("K1\\SK2"),
                new Entity("K1\\SK1"),
                new Entity("K1\\SK1\\SSK2"),
                new Entity("K1\\SK1\\SSK1")
        );
        assertThat(result, is(expect));
    }

}