package ru.job4j.io.server;

public class WrongParametersException extends Exception {
    public WrongParametersException() {
        super();
    }

    public WrongParametersException(String description) {
        super(description);
    }
}
