package ru.job4j.io.server;

public class Server {
    public void start() {

    }
    public static void main(String[] args) {
        Config prop = new FileConfig();
        prop.init();
        System.out.println(prop.toString());
    }
}
