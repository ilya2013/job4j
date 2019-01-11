package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class UpdateItem implements UserAction {
    private int key;
    private String info;

    public UpdateItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Редактирование заявки --------------");
        String id = input.ask("Введите ID заявки: ");
        //Заставляем пользователя вбивать данные при редактировании при ошибке в id
        String name = input.ask("Введите новое имя заявки:");
        String desc = input.ask("Введите новое описание заявки:");
        if (tracker.replace(id, new Item(id, name, desc))) {
            System.out.println("Заявка отредактирована: " + id);
        } else {
            System.out.println("Заявка с указанным id не найдена: " + id);
        }

        System.out.println("------------ Завершено редактирование-----------");

    }

    @Override
    public String info() {
        return info;
    }
}
