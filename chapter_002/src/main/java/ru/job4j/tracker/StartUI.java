package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private MenuTracker menuTracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        menuTracker = new MenuTracker(input, tracker);
        boolean exit = false;
        while (!exit) {
            menuTracker.show();
            //this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (!EXIT.equals(answer)) {
                menuTracker.select(answer);
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }


    /**
     * Запускт программы.
     * @param args Входные запуска
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}