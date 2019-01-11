package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Tracker;

public class DeleteItem implements UserAction {
    private int key;
    private String info;

    public DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Удаление заявки --------------");
        String id = input.ask("Введите ID заявки: ");
        if (tracker.delete(id)) {
            System.out.println(" Заявка удалена: " + id + "-----------");
        } else {
            System.out.println(" Заявка с указанным ID не найдена");
        }
        System.out.println("------------ Завершено удаление заявки-----------");
    }

    @Override
    public String info() {
        return this.info;
    }
}
