package ru.job4j;

import java.util.Arrays;

 class ControlTask {
    public int[] changes(int value, int price) {
        int position = -1;
        int[] result = new int[50];
        if ((value -= price) >= 0) {
            while (value > 0) {
                if (value >= 50) {
                    result[++position] = 50;
                    value -= 50;
                } else if (value >= 10) {
                    result[++position] = 10;
                    value -= 10;
                } else if (value >= 5) {
                    result[++position] = 5;
                    value -= 5;
                } else if (value >= 2) {
                    result[++position] = 2;
                    value -= 2;
                } else {
                    result[++position] = 1;
                    value -= 1;
                }
            }
        } else result[0] = 0;
        return result;
    }
}


