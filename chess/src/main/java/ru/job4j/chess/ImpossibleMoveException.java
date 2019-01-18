package ru.job4j.chess;

public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException() {
        super();
    }

    public ImpossibleMoveException(String description) {
        super(description);
    }
}
