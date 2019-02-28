package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FindByNameItem extends BaseAction {

    public FindByNameItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("%s%s", "------------Поиск заявки по имени  --------------", System.lineSeparator()));
        String name = input.ask("Введите имя заявки: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item item : items) {
                output.accept(String.format("Заявка: %S, описание: %s, создана: %d %s", item.getName(), item.getDesc(), item.getCreated(), System.lineSeparator()));
            }
        } else {
            output.accept(String.format("%s%s", " Заявка с указанным name не найдена", System.lineSeparator()));
        }
        output.accept(String.format("%s%s", "------------ Поиск заявки по имени завершён-----------", System.lineSeparator()));
    }
}
