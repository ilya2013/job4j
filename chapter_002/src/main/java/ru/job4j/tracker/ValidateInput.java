package ru.job4j.tracker;

public class ValidateInput implements Input {
    private Input input;
    public ValidateInput(Input input) {
        this.input = input;
    }

    public String ask(String question) {
        return this.input.ask(question);
    }
    @Override
    public int ask(String question, int[] range) {
        int key = -1;
        boolean invalid = true;
        do {
            try {
                key = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Введите валидные данные.");
            } catch (MenuOutException e) {
                System.out.println("Выберете существуюший пункт меню.");
            }
        }
        while (invalid);
        return key;
    }
}
