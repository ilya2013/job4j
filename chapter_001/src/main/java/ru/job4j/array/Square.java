package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int element;
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int idx = 0; idx < bound; idx++) {
            element = idx + 1;
            rst [idx] = element * element;
        }
        return rst;
    }
}
