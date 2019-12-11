package ru.job4j.io.config;

import ru.job4j.io.config.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileConfig implements Config {
private final Map<String, String>  prop = new HashMap<>();

    @Override
    public String get(String key) {
        return prop.get(key);
    }

    @Override
    public void init() {
    }

    @Override
    public void init(Reader reader) {
        Properties property = new Properties();
        try (Reader rdr = reader) {
            property.load(rdr);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        property.forEach((o, o2) -> prop.put((String) o, (String) o2));
    }

    @Override
    public void setProperty(String name, String value) {
        prop.put(name, value);
    }


    @Override
    public String toString() {
        return prop.toString();
    }
}
