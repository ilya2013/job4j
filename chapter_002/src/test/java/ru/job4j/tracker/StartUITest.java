package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class StartUITest {
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

//    @Test
//    public void whenAddTwoItemEditOneThenStayOne() {
//        String[] steps = {"0", //Выбор добавления заявки
//                "item1", "desc1", //Добавление заявки
//                "0", //Выбор добавления заявки
//                "item2", "desc2", //Добавление заявки
//                "5",
//                "item2",
//                "1",
//                "6"}; //Выход из программы
//        StubInput stubInput = new StubInput(steps);
//        StartUI startUI = new StartUI(stubInput, new Tracker());
//        startUI.init();
//    }
}