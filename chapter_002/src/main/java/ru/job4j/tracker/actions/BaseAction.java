package ru.job4j.tracker.actions;

import java.util.function.Consumer;

public abstract class BaseAction implements UserAction {
    private  final int key;
    private  final String info;
    protected final Consumer<String> output;

    protected BaseAction(final int key, final String info, final Consumer<String> output) {
        this.key = key;
        this.info = info;
        this.output = output;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.info);
    }

}
