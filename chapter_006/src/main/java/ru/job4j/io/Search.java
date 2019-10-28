package ru.job4j.io;

import java.io.File;
import java.util.*;

public class Search {
    public List<File> files(String parent, List<String> exts) {
        Queue<File> queue = new LinkedList<>();
        List<File> result = new ArrayList<>();
        queue.add(new File(parent));
        for (File file = queue.poll(); file != null; file = queue.poll()) {
            if (file.isFile() && (isNeededExt(file, exts))) {
                result.add(file);
            } else if (file.isDirectory()) {
                addChildren(file, queue);
            }
        }
        return result;
    }

    private boolean isNeededExt(File file, List<String> exts) {
        return exts.stream().anyMatch(e -> file.getName().endsWith("." + e));
    }

    private void addChildren(File file, Queue<File> queue) {
        if (file != null && file.listFiles() != null && file.listFiles().length != 0) {
            Collections.addAll(queue, file.listFiles());
        }
    }
}
