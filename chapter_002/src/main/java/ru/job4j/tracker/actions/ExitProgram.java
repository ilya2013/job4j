package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class ExitProgram extends BaseAction {

    public ExitProgram(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }
}
