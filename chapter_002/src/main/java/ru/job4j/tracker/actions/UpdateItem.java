package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("%s%s", "------------Редактирование заявки --------------", System.lineSeparator()));
        String id = input.ask("Введите ID заявки: ");
        //Заставляем пользователя вбивать данные при редактировании при ошибке в id
        String name = input.ask("Введите новое имя заявки:");
        String desc = input.ask("Введите новое описание заявки:");
        if (tracker.replace(id, new Item(id, name, desc))) {
            output.accept(String.format("%s%s", "Заявка отредактирована: " + id, System.lineSeparator()));
        } else {
            output.accept(String.format("%s%s", "Заявка с указанным id не найдена: " + id, System.lineSeparator()));
        }

        output.accept(String.format("%s%s", "------------ Завершено редактирование-----------", System.lineSeparator()));

    }
}
