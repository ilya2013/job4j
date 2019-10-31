package ru.job4j.io.chat;

import org.junit.Test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class ConsoleChatTest {

    @Test
    public void whenPersonLetSayOnePhraseNormallyThenPhrases4() {
        final Queue<String> result = new LinkedList<>();
        int expectedBotPhraseCount = 4;
        String[] words = {"Привет", Const.PAUSE, Const.CONTINUE, Const.STOP};
        ConsoleChat consoleChat = new ConsoleChat("./data/Chat/botPhrases.txt", new StubInputImpl(words), new Consumer<String>() {
            @Override
            public void accept(String s) {
                result.add(s);
            }
        });
        consoleChat.start();
        assertThat(result.size(), is(expectedBotPhraseCount));

    }

    @Test
    public void whenStopedfterLetContinueAndStop3Phrases() {
        final Queue<String> result = new LinkedList<>();
        int expectedBotPhraseCount = 3;
        String[] words = {Const.PAUSE, Const.CONTINUE, Const.STOP};
        ConsoleChat consoleChat = new ConsoleChat("./data/Chat/botPhrases.txt", new StubInputImpl(words), new Consumer<String>() {
            @Override
            public void accept(String s) {
                result.add(s);
            }
        });
        consoleChat.start();
        assertThat(result.size(), is(expectedBotPhraseCount));
    }

    @Test
    public void whenJustHiStopBuyThen2Phrases() {
        final Queue<String> result = new LinkedList<>();
        int expectedBotPhraseCount = 2;
        String[] words = {Const.PAUSE, Const.STOP};
        ConsoleChat consoleChat = new ConsoleChat("./data/Chat/botPhrases.txt", new StubInputImpl(words), new Consumer<String>() {
            @Override
            public void accept(String s) {
                result.add(s);
            }
        });
        consoleChat.start();
        assertThat(result.size(), is(expectedBotPhraseCount));
    }

    @Test
    public void whenJustHiBuyThen2Phrases() {
        final Queue<String> result = new LinkedList<>();
        int expectedBotPhraseCount = 2;
        String[] words = {Const.STOP};
        ConsoleChat consoleChat = new ConsoleChat("./data/Chat/botPhrases.txt", new StubInputImpl(words), new Consumer<String>() {
            @Override
            public void accept(String s) {
                result.add(s);
            }
        });
        consoleChat.start();
        assertThat(result.size(), is(expectedBotPhraseCount));
    }
}