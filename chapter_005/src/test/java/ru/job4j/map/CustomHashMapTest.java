package ru.job4j.map;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class CustomHashMapTest {
    @Test
    public void whenInsertThenGetByKey() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(2);
        assertThat(map.insert(1, "1"), is(true));
        assertThat(map.insert(-2, "2"), is(true));
        assertThat(map.insert(3, "3"), is(true));
        assertThat(map.get(1), is("1"));
        assertThat(map.get(-2), is("2"));
        assertThat(map.get(3), is("3"));
    }

    @Test
    public void whenInsertExistingKeyThenNewValue() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(2);
        assertThat(map.insert(1, "prev"), is(true));
        assertThat(map.insert(1, "new"), is(true));
        assertThat(map.get(1), is("new"));
    }

    @Test
    public void whenInsertThenContainsAll() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(0);
        map.insert(1, "1");
        map.insert(2, "2");
        map.insert(3, "3");
        map.insert(4, "4");
        map.insert(5, "5");
        assertThat(map.get(1), is("1"));
        assertThat(map.get(2), is("2"));
        assertThat(map.get(3), is("3"));
        assertThat(map.get(4), is("4"));
        assertThat(map.get(5), is("5"));
    }

    @Test
    public void whenDeleteThenDoesNotContain() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(2);
        map.insert(1, "1");
        map.insert(2, "2");
        assertThat(map.get(1), is("1"));
        assertThat(map.get(2), is("2"));
        assertThat(map.delete(1), is(true));
        assertThat(map.delete(1), is(false));
        assertNull(map.get(1));
        assertThat(map.get(2), is("2"));
        assertThat(map.delete(2), is(true));
        assertThat(map.delete(2), is(false));
        assertNull(map.get(2));
    }

    @Test
    public void whenDeleteNonExistingElementThenFalse() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(2);
        map.insert(1, "1");
        assertThat(map.delete(2), is(false));
    }

    @Test
    public void whenIterateThenGetAllEntries() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>(23);
        map.insert(1, "1");
        map.insert(33, "33");
        Iterator it = map.iterator();
        assertThat(it.hasNext(), is(true));
        CustomHashMap.Entry<Integer, String> entry = (CustomHashMap.Entry<Integer, String>) it.next();
        assertThat(entry.getKey(), is(1));
        assertThat(entry.getValue(), is("1"));
        entry = (CustomHashMap.Entry<Integer, String>) it.next();
        assertThat(entry.getKey(), is(33));
        assertThat(entry.getValue(), is("33"));
        assertThat(it.hasNext(), is(false));
    }
}
