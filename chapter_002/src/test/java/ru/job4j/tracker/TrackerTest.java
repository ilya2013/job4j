package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void when2ItemsWithTheSameNameThenFind2Item() {
        List<Item> result;
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("test1", "testDescription", 123L));
        expected.add(new Item("test1", "testDescription2", 1234L));
        Tracker tracker = new Tracker();
        Item item1 = expected.get(0);
        tracker.add(item1);
        Item item2 = expected.get(1);
        tracker.add(item2);
        tracker.add(new Item("test2", "testDescription3", 12345L));
        result = tracker.findByName("test1");
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoItemInTrackerThenAfterDeleteStayOne() {
        List<Item> result;
        Tracker tracker = new Tracker();
        List<Item> items = new ArrayList<>();
        items.add(new Item("test1", "testDescription", 123L));
        items.add(new Item("test1", "testDescription2", 1234L));
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(items.get(1));

        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.delete(items.get(0).getId());
        result = tracker.findAll();
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoItemInTrackerThenAfterDeleteStayOne2() {
        List<Item> result;
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("test1", "testDescription", 123L));
        items.add(new Item("test1", "testDescription2", 1234L));
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(items.get(0));
        Tracker tracker = new Tracker();
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        tracker.delete(items.get(1).getId());
        result = tracker.findAll();
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(expected));
    }

    @Test
    public void whenTenItemInTrackerThenAfterDeleteStayOne2() {
        List<Item> result;
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("test1", "testDescription", 123L));
        items.add(new Item("test1", "testDescription1", 123L));
        items.add(new Item("test1", "testDescription2", 123L));
        items.add(new Item("test1", "testDescription3", 123L));
        items.add(new Item("test1", "testDescription4", 123L));
        items.add(new Item("test1", "testDescription5", 123L));
        items.add(new Item("test1", "testDescription6", 123L));
        items.add(new Item("test1", "testDescription7", 123L));
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(items.get(0));
        Tracker tracker = new Tracker();
        //Добавляем элементы в кэш объекта Tracker
        for (Item element : items) {
            tracker.add(element);
        }
        tracker.delete(items.get(1).getId());
        tracker.delete(items.get(2).getId());
        tracker.delete(items.get(3).getId());
        tracker.delete(items.get(5).getId());
        tracker.delete(items.get(6).getId());
        tracker.delete(items.get(4).getId());
        tracker.delete(items.get(7).getId());

        result = tracker.findAll();
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(expected));
    }
}