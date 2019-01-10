package ru.job4j.tracker;

public class MenuOutException extends RuntimeException {

    public MenuOutException() {
        super();
    }

    public MenuOutException(String description) {
        super(description);
    }
}
