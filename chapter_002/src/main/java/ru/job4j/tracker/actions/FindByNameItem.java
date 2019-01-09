package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindByNameItem implements UserAction {
    private int key = 5;
    private String info = "Find items by name";

    public FindByNameItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Поиск заявки по имени  --------------");
        String name = input.ask("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item item : items) {
                System.out.format("Заявка: %S, описание: %s, создана: %d \n", item.getName(), item.getDesc(), item.getCreated());
            }
        } else {
            System.out.println(" Заявка с указанным name не найдена");
        }
        System.out.println("------------ Поиск заявки по имени завершён-----------");
    }

    @Override
    public String info() {
        return this.info;
    }
}
