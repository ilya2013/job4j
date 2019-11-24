package ru.job4j.io.server;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Config {
    String get(String key);
    void init();
    void init(Reader reader);
    void setProperty(String name, String value);
}
