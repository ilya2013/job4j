package ru.job4j.tracker;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /** Вывод данных
     *
     */
    private Consumer<String> output;

    private MenuTracker menuTracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        menuTracker = new MenuTracker(input, tracker, this.output);
        boolean exit = false;
        while (!exit) {
            menuTracker.show();
            int answer = this.input.ask("Введите пункт меню : ", menuTracker.menuKeys());
            if (EXIT != answer) {
                menuTracker.select(String.valueOf(answer));
            } else {
                exit = true;
            }
        }
    }


    /**
     * Запускт программы.
     * @param args Входные запуска
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::print).init();
    }
}