package ru.job4j.io.server;

import ru.job4j.io.config.Config;
import ru.job4j.io.server.action.CD;
import ru.job4j.io.server.action.ClientAction;
import ru.job4j.io.server.action.LS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Оркестрация команд.
 */
public class ActionsController implements Runnable {
    private final Consumer<String> out;
    private final Config props;
    private  Explorer explorer;
    private  Socket socket;
    private final Map<String, ClientAction> actions = new HashMap<>();
    private boolean stop = false;
    private static final String STOP_COMMAND = "exit";
    private static final String HELP_COMMAND = "-help";
    private static final String LS = System.lineSeparator();

    public ActionsController(Config props, Consumer<String> out) throws IOException {
        this.props = props;
        this.out = out;
    }

    private void init() {
        try {
            System.out.println("Ожидание подключения");
            this.socket = new ServerSocket(Integer.parseInt(props.get("server.socket.port"))).accept();
            System.out.println("Выполнено подключение");
            this.explorer = new FileManager(props);
            fillActions();
        } catch (Exception e) {
            System.out.println("Ошибка инициализации");
        }
    }
    public void fillActions() {
        actions.put("cd", new CD("cd", "Изменение текущей директории", this.out));
        actions.put("ls", new LS("ls", "Отображение элементов текущей папки", this.out));
    }

    private void formMessage(OutputStream sOut, String message) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sOut));
            bufferedWriter.write(message);
            out.accept(message);
        } catch (Exception e) {
            out.accept("Ошибка при попытке передачи сообщения");
        }
    }

    private void sendMessage(OutputStream sOut) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sOut));
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {
            out.accept("Ошибка при попытке передачи сообщения");
        }
    }

    @Override
    public void run() {
        String line;
        String command;
        List<String> args;
        BufferedReader bufferedReader;
        init();
        try (OutputStream sOut = this.socket.getOutputStream();
             InputStream sIn = this.socket.getInputStream()) {
            bufferedReader = new BufferedReader(new InputStreamReader(sIn));
            formMessage(sOut, explorer.currentDir().getCanonicalPath() + ">" + LS);
            sendMessage(sOut);
            while (!this.stop && ((line = bufferedReader.readLine())) != null) {
                out.accept("Получена строка: " + line);
                args = Arrays.stream(line.trim()
                        .split(" "))
                        .collect(Collectors.toList());
                if (args.size() != 0) {
                    command = args.get(0);
                    if (command.equals(STOP_COMMAND)) {
                        stop = true;
                    } else if (actions.containsKey(command)) {
                        actions.get(command).execute(sIn, sOut, explorer, args);
                    } else if (HELP_COMMAND.equals(command)) {
                       actions.forEach(new BiConsumer<String, ClientAction>() {
                           @Override
                           public void accept(String s, ClientAction clientAction) {
                               formMessage(sOut, clientAction.info() + Server.LS);
                           }
                       });
                    } else {
                        formMessage(sOut, "Неизвестная команда. Для просмотра списка команд воспользуйтесь -help");
                    }
                } else {
                    stop = true;
                }
                formMessage(sOut, explorer.currentDir().getCanonicalPath() + ">" + LS);
                sendMessage(sOut);
                out.accept("Работа с сообшением успешно окончена");
            }
        } catch (Exception e) {
            out.accept(e.toString());
        }
    }
}
