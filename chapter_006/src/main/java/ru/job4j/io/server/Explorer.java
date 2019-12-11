package ru.job4j.io.server;

import java.io.*;
import java.util.List;

/**
 * Интерфейс работы с файловой структурой.
 * @author Ilya Beskhmelnitsin
 * @since 25.11.19
 */
public interface Explorer {
    /**
     * Список файлов и подкаталогов.
     * @return Set<File> файлы, подкаталоги.
     */
    List<File> ls();

    /**
     * Получение родительского каталога.
     * @return
     */
    File parentDir();

    /**
     * Изменение каталогу по абсолютному пути.
     * @param path
     */
    void cd(String path) throws Exception;

    /**
     * Получение текущей директории.
     * @return Текущая директория.
     */
    File currentDir();

    /**
     * Сохранение файла на сервер в текущую директорию.
     * @param name название файла.
     * @param reader Reader загружаемого файла.
     * @return Успех загрузки.
     */
    boolean save(String name, InputStream reader) throws IOException;

    /**
     * Скачивание файла на сервер в текущую директорию.
     */
    BufferedOutputStream getFileStream(File file) throws Exception;

}
