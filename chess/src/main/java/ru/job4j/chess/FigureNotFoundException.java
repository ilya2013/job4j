package ru.job4j.chess;

public class FigureNotFoundException extends Exception {
    public FigureNotFoundException() {
        super();
    }

    public FigureNotFoundException(String description) {
        super(description);
    }
}
