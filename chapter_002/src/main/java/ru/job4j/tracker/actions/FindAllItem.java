package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindAllItem  implements UserAction {
    private int key;
    private String info;

    public FindAllItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.println("------------ Заявка : " + item.toString() + "-----------");
            } else {
                break;
            }
        }
    }

    @Override
    public String info() {
        return info;
    }
}
