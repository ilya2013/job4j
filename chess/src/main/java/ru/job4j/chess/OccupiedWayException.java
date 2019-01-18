package ru.job4j.chess;

public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
        super();
    }

    public OccupiedWayException(String description) {
        super(description);
    }
}
