package ru.job4j.io.server.action;

import org.w3c.dom.ls.LSOutput;
import ru.job4j.io.server.Explorer;

import java.io.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * Изменение директории.
 */
public class CD extends BaseAction {

    public CD(String key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(InputStream in, OutputStream out, Explorer explorer, List<String> args) throws Exception {
        String fileName;
        PrintWriter pw = new PrintWriter(out);
        if (args == null)  {
            throw new Exception();
        } else if (args.size() != 2){
            throw new Exception();
        }
        try {
            fileName = args.get(1);
            System.out.println("Переход в папку" + fileName);
            explorer.cd(explorer.currentDir().getCanonicalPath() + "/" + fileName);
            sendMessage(out, (String) null);
        } catch (Exception e) {
            System.err.println(e.getStackTrace().toString());
        }
    }
}
