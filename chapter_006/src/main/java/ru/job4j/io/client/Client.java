package ru.job4j.io.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;
    private final Scanner console;
    protected static final String STOP_KEY = "exit";
    protected static final String LS = System.getProperty("line.separator");


    public Client(Socket socket, InputStream in) throws IOException {
        this.socket = socket;
        this.console = new Scanner(in);
    }

    public void start() throws IOException {
        try (OutputStream socketOutput = socket.getOutputStream()) {
            PrintWriter out = new PrintWriter(socketOutput, true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean stop;
            String str;
            Thread.sleep(1000);
            for (String answer = in.readLine(); answer != null && !answer.isEmpty(); answer = in.readLine()) {
                System.out.println(answer);
                break;
            }
            do {
                str = console.hasNext() ? console.nextLine() : "";
                out.println(str);
                System.out.println("Отправлено сообщение: " + str);
                stop = STOP_KEY.equals(str);
                for (String answer = in.readLine(); answer != null && !answer.isEmpty(); answer = in.readLine()) {
                    System.out.println(answer);
                }
                System.out.println("Окончание ответа от сервера");
            } while (!stop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Client(new Socket("127.0.0.1", 10001), System.in).start();
    }
}
