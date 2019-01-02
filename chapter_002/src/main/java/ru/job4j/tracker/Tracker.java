package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Обертка над массивом
 */
public class Tracker {
    private  int limit = 10;
    private Item[] items = new Item[limit];
    private int position = -1;

    public Tracker() {
    }

    public Tracker(int limit) {
        this.limit = limit;
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
    public  Item add(Item item) {
        item.setId(generateId());
        if (position < limit - 1) {
            position++;
            items[position] = item;
        } else {
            System.out.println("Превышен лимит");
        }
        return item;
    }

    /**
     * Обновление записи
     * @param id уникальный идектификатор
     * @param item запись
     */
    public  boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i <= position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
            }
        }
        return  result;
    }
    /**
     * Удаление записи по id
     * @param id уникальный идентификатор запись
     */
    public  boolean delete(String id) {
        boolean result = false;
        for (int pos = 0; pos <= position; pos++) {
            if (items[pos] != null && items[pos].getId().equals(id)) {
                if (pos != position) {
                    System.arraycopy(items, pos + 1, items, pos, items.length - pos - 1);
                }
                this.position--;
//                items = Arrays.copyOf(Arrays.copyOf(items, items.length - 1), items.length);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Вернуть все записи
     * @return записи
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position + 1);
    }

    /**
     * Поиск по имени
     * @param key имя записи
     */
    public  Item[] findByName(String key) {
        int idx = 0;
        Item[] result = new Item[limit];
        for (int pos = 0; pos <= position; pos++) {
            if (items[pos] != null && items[pos].getName().equals(key)) {
                result[idx] = items[pos];
                idx++;
            }
        }
        return Arrays.copyOf(result, idx);
    }
    /**
     * Поиск по id
     * @param id уникальный идентификатор
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

}
