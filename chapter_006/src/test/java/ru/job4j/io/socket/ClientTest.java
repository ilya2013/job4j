package ru.job4j.io.socket;

import com.google.common.base.Joiner;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {
    private final static String LS = System.getProperty("line.separator");

    @Test
    public void whenHiAndExitThen() throws IOException {
        clientTest(Joiner.on(LS).join("Hi", "exit"), Joiner.on(LS).join("Hi", "exit" + LS));
    }

    @Test
    public void whenExitThenExit() throws IOException {
        clientTest("exit" + LS, "exit" + LS);
    }

    @Test
    public void whenHiAndOracleAndExitThenHiAndOracleAndExit() throws IOException {
        clientTest(Joiner.on(LS).join("Hi", "Oracle", "exit"), Joiner.on(LS).join("Hi", "Oracle", "exit" + LS));
    }

    public void clientTest(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        Client client = new Client(socket, new ByteArrayInputStream(input.getBytes()));
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        client.start();
        assertThat(out.toString(), is(expected));
    }
}