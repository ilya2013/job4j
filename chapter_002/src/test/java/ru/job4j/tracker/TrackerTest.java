package ru.job4j.tracker;

import org.junit.Test;

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
        assertThat(tracker.findAll()[0], is(item));
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
        Item[] result;
        Item[] expected = new Item[10];
        expected[0] = new Item("test1", "testDescription", 123L);
        expected[1] = new Item("test1", "testDescription2", 1234L);
        Tracker tracker = new Tracker();
        Item item1 = expected[0];
        tracker.add(item1);
        Item item2 = expected[1];
        tracker.add(item2);
        tracker.add(new Item("test2", "testDescription3", 12345L));
        result = tracker.findByName("test1");
        assertThat(result, arrayContainingInAnyOrder(expected));
    }

    @Test
    public void whenTwoItemInTrackerThenAfterDeleteStayOne() {
        Item[] result;
        Item[] item = new Item[10];
        item[0] = new Item("test1", "testDescription", 123L);
        item[1] = new Item("test1", "testDescription2", 1234L);
        Item[] expected = new Item[10];
        expected[0] = item[1];
        Tracker tracker = new Tracker();
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.delete(item[0].getId());
        result = tracker.findAll();
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(expected));

    }


}