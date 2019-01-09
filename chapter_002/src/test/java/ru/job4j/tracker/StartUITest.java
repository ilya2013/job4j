package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    PrintStream stdout = System.out;
    // Создаем буфур для хранения вывода.
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    //Заменяем стандартный вывод на вывод в пямять для тестирования.
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddOneItemThenShowsOneItem() {
        String[] steps = {"0", //Выбор добавления заявки
                "item1", "desc1", //Добавление заявки
                "1",
                "6"}; //Выход из программы
        StubInput stubInput = new StubInput(steps);
        StartUI startUI = new StartUI(stubInput, new Tracker());
        startUI.init();
    }

    @Test
    public void whenAddTwoItemDeleteOneThenStayOne() {
        String[] steps = {"0", //Выбор добавления заявки
                "item1", "desc1", //Добавление заявки
                "0", //Выбор добавления заявки
                "item2", "desc2", //Добавление заявки
                "5",
                "item2",
                "1",
                "6"}; //Выход из программы
        StubInput stubInput = new StubInput(steps);
        StartUI startUI = new StartUI(stubInput, new Tracker());
        startUI.init();
    }

    @Test
    public void whenAddTwoItemEditOneThenStayOne() {
        String[] steps = {"0", //Выбор добавления заявки
                "item1", "desc1", //Добавление заявки
                "0", //Выбор добавления заявки
                "item2", "desc2", //Добавление заявки
                "5",
                "item2",
                "1",
                "6"}; //Выход из программы
        StubInput stubInput = new StubInput(steps);
        StartUI startUI = new StartUI(stubInput, new Tracker());
        startUI.init();
    }
@Test
public void whenAddOneItemThenShowsOneItem2() {
    String[] steps = {"1",
            "6"}; //Выход из программы
    StubInput stubInput = new StubInput(steps);
    Tracker tracker = new Tracker();
    Item testItem = new Item("item1", "desc1", 1L);
    tracker.add(testItem);
    StartUI startUI = new StartUI(stubInput, tracker);
    startUI.init();
    assertThat(
            new String(out.toByteArray()),
            is(
                    new StringBuilder()
                            .append("Меню.\\r\n"
                                    + "0. Add new Item\\r\n"
                                    + "1. Show all items\\r\n"
                                    + "2. Edit item\\r\n"
                                    + "3. Delete item\\r\n"
                                    + "4. Find item by Id\\r\n"
                                    + "5. Find items by name\\r\n"
                                    + "6. Exit Program\\r\n"
                                    + "Введите пункт меню :  1\\r\n"
                                    + "------------ Заявка : Id " + testItem.getId() + ", Name item1, Desc desc1, Created 1-----------\\r\n"
                                    + "Меню.\\r\n"
                                    + "0. Add new Item\\r\n"
                                    + "1. Show all items\\r\n"
                                    + "2. Edit item\\r\n"
                                    + "3. Delete item\\r\n"
                                    + "4. Find item by Id\\r\n"
                                    + "5. Find items by name\\r\n"
                                    + "6. Exit Program\\r\n"
                                    + "Введите пункт меню :  6\\r\\n")
                            .toString()
            )
    );
}
}