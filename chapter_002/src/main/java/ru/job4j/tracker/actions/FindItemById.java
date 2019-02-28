package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("%s%s", "------------Поиск заявки по id  --------------", System.lineSeparator()));
        String id = input.ask("Введите ID заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept(String.format("%s%s", String.format("Заявка: %S, описание: %s, создана: %d", item.getName(), item.getDesc(), item.getCreated()), System.lineSeparator()));
        } else {
            output.accept(String.format("%s%s", " Заявка с указанным ID не найдена", System.lineSeparator()));
        }
        output.accept(String.format("%s%s", "------------ Поиск заявки по id -----------", System.lineSeparator()));
    }
}