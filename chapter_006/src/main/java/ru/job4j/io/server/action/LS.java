package ru.job4j.io.server.action;

import ru.job4j.io.server.Explorer;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LS extends BaseAction {
    public LS(String key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(InputStream in, OutputStream out, Explorer explorer, List<String> args) throws Exception {
        if (args == null) {
            throw new Exception();
        }
        try {
            sendMessage(out, explorer.ls().stream().map(File::getName).collect(Collectors.toList()));
        } catch (Exception e) {
            System.err.println(e.getStackTrace().toString());
        }
    }
}
