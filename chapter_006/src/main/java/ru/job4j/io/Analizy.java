package ru.job4j.io;

import java.io.*;
import java.util.StringJoiner;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String line;
            StringBuilder startEndTime = new StringBuilder();
           while ((line = read.readLine()) != null) {
               String[] event = line.split(" ");
               if (event.length == 2) {
                   if (startEndTime.length() == 0 && (event[0].equals("500") || event[0].equals("400"))) {
                       startEndTime.append(event[1]);
                   } else if (startEndTime.length() != 0 && !(event[0].equals("500") || event[0].equals("400"))) {
                      out.write(startEndTime.append(";").append(event[1]).append(System.lineSeparator()).toString());
                       startEndTime.delete(0, startEndTime.length());
                   }
               }
           }
           if (startEndTime.length() != 0) {
               out.write(startEndTime.toString());
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
