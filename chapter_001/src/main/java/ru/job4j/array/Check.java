package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        if (data.length == 0) {
            return result;
        }
        boolean check = data [data.length - 1];
        for (boolean element : data) {
            if (element != check) {
                result = false;
                break;
            }
        }
        return result;
    }
}
