package ru.job4j.io.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private final static String LS = System.getProperty("line.separator");

    @Test
    public void whenAskExitThenNoAnswerAndStopServer() throws IOException {
        serverSocketTest("exit", "");
    }

    @Test
    public void whenAskHelloThenHelloImOracle() throws IOException {
        serverSocketTest(Joiner.on(LS).join("Hello", "exit"), Joiner.on(LS).join("Hello, dear friend, I'm a oracle.", "", ""));
    }

    @Test
    public void whenAskRandowThenRepeatRandom() throws IOException {
        serverSocketTest(Joiner.on(LS).join("What?", "exit"), Joiner.on(LS).join("What?", LS));
    }

    public void serverSocketTest(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        new Server(socket).start();
        assertThat(out.toString(), is(expected));
    }
}