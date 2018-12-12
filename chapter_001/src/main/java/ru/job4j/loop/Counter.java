package ru.job4j.loop;

public class Counter {
    /*
     * Сумма чётных чисел в диапазоне
     * @peram start Начало диапазона
     * @peram finish Конец диапазона
     */
    public int add(int start, int finish) {
        int summa = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                summa += i;
            }
        }
        return summa;
    }
}
