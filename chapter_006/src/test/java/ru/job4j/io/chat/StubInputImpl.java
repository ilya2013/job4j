package ru.job4j.io.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class StubInputImpl implements Input {
    private Queue<String> lines = new LinkedList<>();

    public StubInputImpl(String[] word) {
        Collections.addAll(lines, word);
    }

    @Override
    public String listen() {
        return lines.poll();
    }
}
