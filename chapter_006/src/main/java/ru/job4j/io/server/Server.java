package ru.job4j.io.server;

import ru.job4j.io.config.Config;
import ru.job4j.io.config.FileConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.Consumer;

public class Server {
    public static final String LS = System.lineSeparator();
    public void start() {

    }
    public static void main(String[] args) throws IOException {
        Config prop = new FileConfig();
        final ActionsController actionsController;
        try (Reader in = new FileReader(new File("./chapter_006/data/socket/config.properties"))) {
         prop.init(in);
         actionsController = new ActionsController(prop, new Consumer<String>() {
             @Override
             public void accept(String o) {
                 System.out.println(o);
             }
         });
         new Thread(actionsController).start();
        } catch (Exception e) {
            System.out.println("Ошибка");
        }

    }
}
