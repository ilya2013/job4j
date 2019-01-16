package ru.job4j.chess.firuges;

public class ImposibleMoveException extends Exception {
    public ImposibleMoveException() {
        super();
    }

    public ImposibleMoveException(String description) {
        super(description);
    }
}
