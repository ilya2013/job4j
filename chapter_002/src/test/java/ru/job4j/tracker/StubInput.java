package ru.job4j.tracker;

import java.util.function.Consumer;

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меню "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] value;
    private  final Consumer<String> output;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] value, Consumer<String> output) {
        this.value = value;
        this.output = output;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        output.accept(String.format("%s%s", question + " " + this.value[this.position], System.lineSeparator()));
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        int result = -1;
        boolean exists = false;
        int currenPosition = this.position;
        this.position++;
        output.accept(String.format("%s%s", question + " " + this.value[currenPosition], System.lineSeparator()));
        for (int value : range) {
            if (Integer.valueOf(this.value[currenPosition]) == value) {
                exists = true;
                result = Integer.valueOf(this.value[currenPosition]);
            }
        }
        if (!exists) {
            throw new MenuOutException();
        }
        return result;
    }


}
