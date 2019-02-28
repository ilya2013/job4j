package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {

    public ExitProgram(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }
}
