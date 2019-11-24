package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Server {
    private final Socket socket;

    public  Server(Socket socket) {
        this.socket = socket;
    }

public void start() {
    try {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask = null;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            if (ask.contains("Hello")) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (!ask.equals("exit")) {
                System.out.println(ask);
                out.println(ask);
                out.println();
            }
        } while (!"exit".equals(ask));
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) throws IOException {
        new Server(new ServerSocket(10001).accept()).start();
    }
}
