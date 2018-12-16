package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value
        if (data.length >= value.length) {
            for (int ind = 0; ind < value.length; ind++) {
                if (value [ind] != data [ind]) {
                    return false;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
