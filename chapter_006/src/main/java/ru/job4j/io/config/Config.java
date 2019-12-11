package ru.job4j.io.config;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Config {
    String get(String key);
    void init();
    void init(Reader reader);
    void setProperty(String name, String value);
}
