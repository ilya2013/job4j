package ru.job4j.io.server;

import org.junit.Test;

public class FileConfigTest {

    @Test
    public void test() {
       Config prop = new FileConfig();
       prop.init();
       prop.setProperty("test", "testv");
        System.out.println(prop.toString());
    }
}