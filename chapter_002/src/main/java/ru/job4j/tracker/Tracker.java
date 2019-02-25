package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Обертка над массивом
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();

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
    public  Item add(Item item) {
        item.setId(generateId());
        items.add(item);

        return item;
    }

    /**
     * Обновление записи
     * @param id уникальный идектификатор
     * @param item запись
     */
    public  boolean replace(String id, Item item) {
        boolean result = false;
        int ind = -1;
        for (Item element : items) {
            ++ind;
            item.setCreated(element.getCreated());
            if (element.getId().equals(id)) {
                items.set(ind, item);
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
        int ind = -1;
        for (Item item : items) {
            ++ind;
            if (item.getId().equals(id)) {
              items.remove(ind);
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Поиск по имени
     * @param key имя записи
     */
    public  List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }
    /**
     * Поиск по id
     * @param id уникальный идентификатор
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
