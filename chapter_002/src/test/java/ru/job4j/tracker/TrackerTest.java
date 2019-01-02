package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

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
        Item[] expected = new Item[2];
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
        int size = 10;
        Item[] result;
        Tracker tracker = new Tracker();
        Item[] item = new Item[10];
        item[0] = new Item("test1", "testDescription", 123L);
        item[1] = new Item("test1", "testDescription2", 1234L);
        Item[] expected = new Item[10];
        expected[0] = item[1];

        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.delete(item[0].getId());
        result = tracker.findAll();
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(Arrays.copyOf(expected, 1)));
    }

    @Test
    public void whenTwoItemInTrackerThenAfterDeleteStayOne2() {
        Item[] result;
        Item[] item = new Item[10];
        item[0] = new Item("test1", "testDescription", 123L);
        item[1] = new Item("test1", "testDescription2", 1234L);
        Item[] expected = new Item[10];
        expected[0] = item[0];
        Tracker tracker = new Tracker();
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.delete(item[1].getId());
        result = tracker.findAll();
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(Arrays.copyOf(expected, 1)));
    }

    @Test
    public void whenTenItemInTrackerThenAfterDeleteStayOne2() {
        Item[] result;
        Item[] item = new Item[10];
        item[0] = new Item("test1", "testDescription", 123L);
        item[1] = new Item("test1", "testDescription2", 1234L);
        item[2] = new Item("test1", "testDescription3", 1234L);
        item[3] = new Item("test1", "testDescription4", 1234L);
        item[4] = new Item("test1", "testDescription5", 1234L);
        item[5] = new Item("test1", "testDescription6", 1234L);
        item[6] = new Item("test1", "testDescription7", 1234L);
        item[7] = new Item("test1", "testDescription8", 1234L);
        item[8] = new Item("test1", "testDescription9", 1234L);
        item[9] = new Item("test1", "testDescription10", 1234L);
        Item[] expected = new Item[10];
        expected[0] = item[0];
        Tracker tracker = new Tracker();
        //Добавляем элементы в кэш объекта Tracker
        for (Item element : item) {
            tracker.add(element);
        }
        tracker.delete(item[1].getId());
        tracker.delete(item[9].getId());
        tracker.delete(item[8].getId());
        tracker.delete(item[5].getId());
        tracker.delete(item[6].getId());
        tracker.delete(item[7].getId());
        tracker.delete(item[4].getId());
        tracker.delete(item[3].getId());
        tracker.delete(item[2].getId());
        result = tracker.findAll();
        System.out.println(Arrays.toString(result));
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(Arrays.copyOf(expected, 1)));
    }

    @Test
    public void when4ItemInTrackerThenAfterDeleteOneStayThree2() {
        Item[] result;
        Item[] item = new Item[10];
        item[0] = new Item("test1", "testDescription", 123L);
        item[1] = new Item("test2", "testDescription2", 1234L);
        item[2] = new Item("test3", "testDescription3", 12345L);
        item[3] = new Item("test4", "testDescription4", 123346L);
        Item[] expected = new Item[10];
        expected[0] = item[0];
        expected[1] = item[1];
        expected[2] = item[3];
        Tracker tracker = new Tracker();
        tracker.add(item[0]);
        tracker.add(item[1]);
        tracker.add(item[2]);
        tracker.add(item[3]);
//        tracker.delete(item[1].getId());
        tracker.delete(item[2].getId());
        result = tracker.findAll();
//        assertThat(result, arrayContainingInAnyOrder(expected));
        assertThat(result, is(Arrays.copyOf(expected, 3)));
    }
}