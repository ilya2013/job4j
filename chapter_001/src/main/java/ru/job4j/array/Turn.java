package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int tmp;
        for (int idx = 0; idx < (array.length / 2); idx++) {
            tmp = array [idx];
            array [idx] = array [array.length - idx - 1];
            array [array.length - idx - 1] = tmp;
            System.out.println(idx);
        }
        return array;
    }
}
