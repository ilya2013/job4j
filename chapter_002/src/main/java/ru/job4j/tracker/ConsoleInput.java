package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    @Override
    public int ask(String question, int[] range) {
        boolean exists = false;
        System.out.println(question + System.lineSeparator());
        int key = Integer.valueOf(scanner.next());
        for (int value : range) {
            if (key == value) {
                exists = true;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException();
        }
    }
}
