package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void thenErrorStillExistThenOpenErrorTime() throws IOException {
        Analizy analizy = new Analizy();
        List<String> expectedReport = new ArrayList<>();
        expectedReport.add("10:57:00;10:59:02");
        expectedReport.add("11:01:03;11:02:04");
        expectedReport.add("11:02:07");
        String sourceFilePath = "./data/Analizy/logWithOpenError.log";
        String targetFilePath = "./data/Analizy/reportWithOpenError.csv";
        List<String> result;
        analizy.unavailable(sourceFilePath, targetFilePath);
        try (BufferedReader read = new BufferedReader(new FileReader(targetFilePath))) {
            result = read.lines().collect(Collectors.toList());
        } catch (IOException ex) {
            throw ex;
        }
        assertThat(result, is(expectedReport));
    }

    @Test
    public void thenAllErrorsClosedThenClosedTime() throws IOException {
        Analizy analizy = new Analizy();
        List<String> expectedReport = new ArrayList<>();
        expectedReport.add("10:57:00;10:59:02");
        expectedReport.add("11:01:03;11:02:04");
        String sourceFilePath = "./data/Analizy/logWithClosedError.log";
        String targetFilePath = "./data/Analizy/reportWithOpenError.csv";
        List<String> result = new ArrayList<>();
        analizy.unavailable(sourceFilePath, targetFilePath);
        try (BufferedReader read = new BufferedReader(new FileReader(targetFilePath))) {
            result = read.lines().collect(Collectors.toList());
        } catch (IOException ex) {
            throw ex;
        }
        assertThat(result, is(expectedReport));
    }
}