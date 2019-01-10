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
        StartUI startUI = new StartUI(new ValidateInput(stubInput), new Tracker());
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
                            .append("0. Add item" + System.lineSeparator()
                                    + "1. Show all items" + System.lineSeparator()
                                    + "2. Edit item" + System.lineSeparator()
                                    + "3. Delete item" + System.lineSeparator()
                                    + "4. Find item by Id" + System.lineSeparator()
                                    + "5. Find items by name" + System.lineSeparator()
                                    + "6. Exit Program" + System.lineSeparator()
                                    + "Введите пункт меню :  1" + System.lineSeparator()
                                    + "------------ Заявка : Id " + testItem.getId() + ", Name item1, Desc desc1, Created 1-----------" + System.lineSeparator()
                                    + "0. Add item" + System.lineSeparator()
                                    + "1. Show all items" + System.lineSeparator()
                                    + "2. Edit item" + System.lineSeparator()
                                    + "3. Delete item" + System.lineSeparator()
                                    + "4. Find item by Id" + System.lineSeparator()
                                    + "5. Find items by name" + System.lineSeparator()
                                    + "6. Exit Program" + System.lineSeparator()
                                    + "Введите пункт меню :  6" + System.lineSeparator())
                            .toString()
            )
    );
}

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.out.toString(),
                is(
                        String.format("Enter invalid" + System.lineSeparator() + "Введите валидные данные." + System.lineSeparator() + "Enter 1" + System.lineSeparator())
                )
        );
    }
}