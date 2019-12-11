package ru.job4j.io.server.action;

import ru.job4j.io.server.Explorer;

import java.io.*;
import java.net.Socket;
import java.util.List;

public interface ClientAction {
        /** Метод возвращает ключ опции.
         * @return ключ
         */
        String key();
        /**
         * Основной метод.
         * @param in объект типа BufferedReader
         * @param out объект типа BufferedWriter
         * @param explorer объект типа Explorer
         * @param args команда
         */
        void execute(InputStream in, OutputStream out, Explorer explorer, List<String> args) throws Exception;
        /**
         * Метод возвращает информацию о данной команде.
         * @return Строка меню
         */
        String info();
}
