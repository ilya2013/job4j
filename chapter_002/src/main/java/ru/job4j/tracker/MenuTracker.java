package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

import java.util.*;
import java.util.function.Consumer;

public class MenuTracker {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех элементов.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для редактирования элемента.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления элемента.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска по id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для поиска по name.
     */
    private static final String FINDBYNAME = "5";
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */

    /**
     * Вывод данных. Функциональное програмирование.
     */
    Consumer<String> output;
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
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
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
        this.actions.put(ADD, (new AddItem(Integer.valueOf(ADD), "Add item")));
        this.actions.put(SHOWALL, (new FindAllItem(Integer.valueOf(SHOWALL), "Show all items")));
        this.actions.put(EDIT, (new UpdateItem(Integer.valueOf(EDIT), "Edit item")));
        this.actions.put(DELETE, (new DeleteItem(Integer.valueOf(DELETE), "Delete item")));
        this.actions.put(FINDBYID, (new FindItemById(Integer.valueOf(FINDBYID), "Find item by Id")));
        this.actions.put(FINDBYNAME, (new FindByNameItem(Integer.valueOf(FINDBYNAME), "Find items by name")));
        this.actions.put("6", new ExitProgram(6, "Exit Program"));
    }

    public int[] menuKeys() {
        int idx = 0;
        int[] menuKeys = new int[this.actions.keySet().size()];
        for (String key : this.actions.keySet()) {
            menuKeys[idx++] = Integer.valueOf(key);
        }
        return menuKeys;
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
                output.accept(String.format("%s%s", action.info(), System.lineSeparator()));
            }
        }
    }
}
