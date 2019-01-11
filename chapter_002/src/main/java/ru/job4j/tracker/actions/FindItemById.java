package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Поиск заявки по id  --------------");
        String id = input.ask("Введите ID заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.format("Заявка: %S, описание: %s, создана: %d", item.getName(), item.getDesc(), item.getCreated());
        } else {
            System.out.println(" Заявка с указанным ID не найдена");
        }
        System.out.println("------------ Поиск заявки по id -----------");
    }
}