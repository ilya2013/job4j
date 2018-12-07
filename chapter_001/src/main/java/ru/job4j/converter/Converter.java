package ru.job4j.converter;
/**
 * Currency convert task class.
 * @author Ilya B
 * @version 1
 * @since 06.12.18
 */
public class Converter {
    /**
     * Метод конвертации из рублей в евро.
     * @author Ilya B
     * @since 06.12.18
     */
    public int rubToEuro(int value) {
        return value / 76;
    }

    /**
     * Метод конвертации из евро в рубли.
     * @author Ilya B
     * @since 06.12.18
     */
    public int euroToRub(int value) {
        return value * 76;
    }

    /**
     * Метод конвертации из рублей в доллары.
     * @author Ilya B
     * @since 06.12.18
     */
    public int rubToDollar(int value) {
        return value / 66;
    }
    /**
     * Метод конвертации из долларов в друбли.
     * @author Ilya B
     * @since 06.12.18
     */
    public int dollarToRub(int value) {
        return value * 66;
    }
}
