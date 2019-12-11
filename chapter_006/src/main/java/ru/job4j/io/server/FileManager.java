package ru.job4j.io.server;

import ru.job4j.io.config.Config;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileManager implements Explorer{
    final File rootPath;
    private File currentPath;
    static final String TO_PARENT = "..";

    public FileManager(Config config) {
    rootPath = new File(config.get("rootPath"));
    currentPath = rootPath;
}
    @Override
    public List<File> ls() {
        return Arrays.asList(currentPath.listFiles());//TODO: Проверка на Null
    }

    @Override
    public File parentDir() {
        return currentPath.getParentFile();
    }

    @Override
    public void cd(String path) throws Exception {
        File file = new File(path);
        if(!file.exists() || file.isFile()) {
            throw new Exception(); //TODO Логика ошибок.
        }
        currentPath = TO_PARENT.equals(path) ? currentPath.getParentFile() : new File(path);
    }

    @Override
    public File currentDir() {
        return currentPath;
    }

    @Override
    public boolean save(String name, InputStream inputStream) throws IOException {
        boolean result;
        File newFile = new File(currentPath, name);
        if (!newFile.createNewFile()) {
            throw new IOException(); //TODO
        }
        try(BufferedOutputStream fOut = new BufferedOutputStream(new FileOutputStream(newFile));
            BufferedInputStream in = new BufferedInputStream(inputStream)) {
            int count;
            byte[] buffer = new byte[8192];
            while ((count = in.read(buffer)) > 0)
            {
                fOut.write(buffer, 0, count);
            }
        }
        result = true;
        return result;
    }

    @Override
    public BufferedOutputStream getFileStream(File file) throws Exception {
        if(file == null || !file.isFile()) {
            throw new Exception();
        }

        return null;
    }

}
