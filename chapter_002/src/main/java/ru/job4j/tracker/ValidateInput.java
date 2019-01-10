package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        int key = -1;
        boolean invalid = true;
        do {
            try {
                key = super.ask(question, range);
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
