package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Обертка над массивом
 */
public class Tracker {
    private final int limit = 100;
    private Item[] items = new Item[limit];
    private int position = 0;

    public Tracker() {
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return "" + System.currentTimeMillis() + (Math.random() * 1000);
    }
    /**
     * Сохранение записи
     * @param item запись
     * @return запись
     */
    public  Item add (Item item) {
        item.setId(generateId());
        if (position < limit - 1) {
            items[position++] = item;
        } else {
            position = 0;
            items [position] =item;
        }
        return item;
    }

    /**
     * Обновление записи
     * @param id уникальный идектификатор
     * @param item запись
     */
    public  void replace (String id, Item item) {
        for (int i = 0; i < limit; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }
    /**
     * Удаление записи по id
     * @param id уникальный идентификатор запись
     */
    public  void delete (String id) {
        for (int pos = 0; pos < limit; pos++) {
            if (items[pos].getId().equals(id)) {
                System.arraycopy(items, pos + 1 , items, pos, items.length - pos);
                items = Arrays.copyOf(items, items.length -1);
                break;
            }
        }
    }
    /**
     * Вернуть все записи
     * @return записи
     */
    public Item[] findAll () {
        return items;
    }

    /**
     * Поиск по имени
     * @param key имя записи
     */
    public  Item[] findByName (String key) {
        //TODO Поиск записи
        return items;
    }
    /**
     * Поиск по id
     * @param id уникальный идентификатор
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

}
