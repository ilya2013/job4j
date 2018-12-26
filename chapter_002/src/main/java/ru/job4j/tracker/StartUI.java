package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                showAll();
            } else if (EDIT.equals(answer)) {
                editItem();
            } else if (DELETE.equals(answer)) {
                deleteItem();
            } else if (FINDBYID.equals(answer)) {
                findById();
            } else if (FINDBYNAME.equals(answer)) {
                findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует отображения всех заявок.
     */
    private void showAll() {
        for (Item item : this.tracker.findAll()) {
            if (item != null) {
                System.out.println("------------ Заявка : " + item.toString() + "-----------");
            } else {
                break;
            }
        }
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("------------Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item =  this.tracker.findById(id);
        if (item != null) {
            String name = this.input.ask("Введите новое имя заявки:");
            String desc = this.input.ask("Введите новое описание заявки:");
//        String comment = this.input.ask("Добавить комментарий:");
            item.setName(name);
            item.setDesc(desc);
//        item.setComments(comment);
            this.tracker.replace(id, item);
            System.out.println("Заявка отредактирована: " + item.getId());
        } else {
            System.out.println(" Заявка с указанным ID не найдена");
        }
        System.out.println("------------ Завершено редактирование-----------");
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item =  this.tracker.findById(id);
        if (item != null) {
            tracker.delete(id);
            System.out.println(" Заявка удалена: " + item.getId() + " " + item.getName() + "-----------");
        } else {
            System.out.println(" Заявка с указанным ID не найдена");
        }
        System.out.println("------------ Завершено удаление заявки-----------");
    }

    /**
     * Метод реализует поиска заявки по id.
     */
    private void findById() {
        System.out.println("------------Поиск заявки по id  --------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.format("Заявка: %S, описание: %s, создана: %d", item.getName(), item.getDesc(), item.getCreated());
        } else {
            System.out.println(" Заявка с указанным ID не найдена");
        }
        System.out.println("------------ Поиск заявки по id -----------");
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findByName() {
        System.out.println("------------Поиск заявки по имени  --------------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(name);
        int found = 0;
        for (Item item : items) {
            if (item != null) {
                System.out.format("Заявка: %S, описание: %s, создана: %d \n", item.getName(), item.getDesc(), item.getCreated());
                found++;
            } else {
                break;
            }
            if (found == 0) {
                System.out.println(" Заявка с указанным name не найдена");
            }
        }
        System.out.println("------------ Поиск заявки по имени завершён-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        String[] questions = {"0. Add new Item",
                "1. Show all items",
                "2. Edit item",
                "3. Delete item",
                "4. Find item by Id",
                "5. Find items by name",
                "6. Exit Program"};
        for (String questionElem : questions) {
            System.out.println(questionElem);
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