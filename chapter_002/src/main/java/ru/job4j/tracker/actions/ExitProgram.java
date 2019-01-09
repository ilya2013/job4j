package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class ExitProgram implements UserAction  {
    private int key = 6;
    private String info = "Exit progam";

    public ExitProgram(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return this.info;
    }
}
