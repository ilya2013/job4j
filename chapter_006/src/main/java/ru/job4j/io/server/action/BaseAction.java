package ru.job4j.io.server.action;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;

public abstract class BaseAction implements ClientAction {
    private  final String key;
    private  final String info;
    protected final Consumer<String> output;

    protected BaseAction(final String key, final String info, final Consumer<String> output) {
        this.key = key;
        this.info = info;
        this.output = output;
    }

    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.info);
    }

    protected void sendMessage(OutputStream out, String message) {
        PrintWriter pw = new PrintWriter(out);
        if (message != null) {
            pw.write(message);
        }
        pw.write(System.lineSeparator());
        pw.flush();
    }
    protected void sendMessage(OutputStream out, List<String> lines) {
        PrintWriter pw = new PrintWriter(out);
        if (lines != null) {
            lines.forEach(pw::println);
        }
        pw.write(System.lineSeparator());
        pw.flush();
    }
}
