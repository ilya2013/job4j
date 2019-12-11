package ru.job4j.io.server;

import org.junit.Test;
import ru.job4j.io.config.Config;
import ru.job4j.io.config.FileConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FileConfigTest {

    @Test
    public void thenCorrectConfigFilePathThenPropertiesAddsFromFile() throws IOException {
        Config prop = new FileConfig();
        File propFile = new File("./data/socket/test/config.properties");
        prop.init(new FileReader(propFile));
        assertThat(prop.get("rootPath"), is("./data"));
        prop.setProperty("test", "testv");
        assertThat(prop.get("test"), is("testv"));
    }
}