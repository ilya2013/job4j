package ru.job4j.max;
/*
 *Вычисление максимального числа.
 * @author Ilya B
 * @version 1
 * @since 11.12.18
 */

public class Max {
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    public int max(int first, int second, int third) {
        int rsl = max(first, second);
        rsl = ((rsl > third) ? rsl : third);
        return rsl;
    }
}
