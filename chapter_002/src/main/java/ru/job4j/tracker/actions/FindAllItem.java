package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindAllItem  extends BaseAction {

    public FindAllItem(int key, String info) {
        super(key, info);
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
}
