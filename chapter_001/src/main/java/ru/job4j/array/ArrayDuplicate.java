package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int doubles = 0;
        String tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - doubles;) {
                if (array[i].equals(array[j])) {
                    tmp = array[j];
                    array[j] = array[array.length - doubles - 1];
                    array[array.length - doubles - 1] = tmp;
                    doubles++;
                } else {
                    j++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - doubles);
    }
}
