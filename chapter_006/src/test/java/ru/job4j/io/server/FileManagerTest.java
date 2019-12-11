package ru.job4j.io.server;

import org.junit.Test;
import ru.job4j.io.config.Config;
import ru.job4j.io.config.FileConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FileManagerTest {

    @Test
    public void currentDir() throws IOException {
        Config prop = new FileConfig();
        String expected = "./data";
        File propFile = new File("./data/socket/test/config.properties");
        prop.init(new FileReader(propFile));
        Explorer fileManager = new FileManager(prop);
        assertThat(fileManager.currentDir().toString(), is(expected));
    }

}