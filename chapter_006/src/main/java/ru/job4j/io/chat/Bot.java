package ru.job4j.io.chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Bot {
    private String phrasesPath;
    private List<String> phrases = new ArrayList<>();

    public Bot(String path) {
        this.phrasesPath = path;
        load();
    }

    private void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.phrasesPath))) {
            read.lines().distinct().forEach(phrases::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String answer() {
        Random random = new Random();
        return phrases.get(random.nextInt(phrases.size() - 1));
    }
}
