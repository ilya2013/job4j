package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class FindAllItem  extends BaseAction {

    public FindAllItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            if (item != null) {
                output.accept(String.format("%s%s", "------------ Заявка : " + item.toString() + "-----------", System.lineSeparator()));
            } else {
                break;
            }
        }
    }
}
