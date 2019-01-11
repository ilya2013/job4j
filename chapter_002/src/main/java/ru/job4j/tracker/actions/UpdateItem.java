package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String info) {
        super(key, info);
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
}
