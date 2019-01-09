package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

import java.util.*;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private Map<String, UserAction> actions = new HashMap<>();
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        fillActions();
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.put("0", (new AddItem(0, "Add item")));
        this.actions.put("1", (new FindAllItem(1, "Show all items")));
        this.actions.put("2", (new UpdateItem(2, "Edit item")));
        this.actions.put("3", (new DeleteItem(3, "Delete item")));
        this.actions.put("4", (new FindItemById(4, "Find item by Id")));
        this.actions.put("5", (new FindByNameItem(5, "Find items by name")));
        this.actions.put("6", new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(String key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions.values()) {
            if (action != null) {
                System.out.format("%d. %s%s", action.key(), action.info(), System.lineSeparator());
            }
        }
    }
}
