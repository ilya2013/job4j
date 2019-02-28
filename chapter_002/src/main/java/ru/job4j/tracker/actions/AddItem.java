package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class AddItem extends BaseAction {

    public AddItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("%s%s", "------------ Добавление новой заявки --------------", System.lineSeparator()));
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept(String.format("%s%s", "------------ Новая заявка с getId : " + item.getId() + "-----------", System.lineSeparator()));
    }
}
