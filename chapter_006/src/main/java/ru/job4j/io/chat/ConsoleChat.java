package ru.job4j.io.chat;

import java.util.function.Consumer;

public class ConsoleChat {
    private final Bot bot;
    private boolean stop = false;
    private boolean pause = false;
    private final Input input;
    private final Consumer<String> out;

    public ConsoleChat(String fileFath, Input in, Consumer<String> out) {
        this.bot = new Bot(fileFath);
        this.input = in;
        this.out = out;
    }

    public void start() {
        String phrase;
        out.accept(Const.GREETING);
        while (!stop) {
            phrase = input.listen().toUpperCase();
            if (phrase.equals(Const.STOP)) {
                stop = true;
                out.accept(Const.FAREWELL);
            } else if (phrase.equals(Const.CONTINUE)) {
                pause = false;
                out.accept(bot.answer());
            } else if (phrase.equals(Const.PAUSE) || pause) {
                pause = true;
            }  else {
                out.accept(bot.answer());
            }
        }
    }
}


