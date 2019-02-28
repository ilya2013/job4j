package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("%s%s", "------------Удаление заявки --------------", System.lineSeparator()));
        String id = input.ask("Введите ID заявки: ");
        if (tracker.delete(id)) {
            output.accept(String.format("%s%s", " Заявка удалена: " + id + "-----------", System.lineSeparator()));
        } else {
            output.accept(String.format("%s%s",  " Заявка с указанным ID не найдена", System.lineSeparator()));
        }
        output.accept(String.format("%s%s", "------------ Завершено удаление заявки-----------", System.lineSeparator()));
    }
}
