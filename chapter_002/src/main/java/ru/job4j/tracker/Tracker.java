package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Обертка над массивом
 */
public class Tracker {
    private ArrayList<Item> items = new ArrayList<>();

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
        for (Item element : items) {
            if (element.getId().equals(id)) {
                items.set(items.indexOf(element), item);
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
    public ArrayList<Item> findAll() {
        return items;
    }

    /**
     * Поиск по имени
     * @param key имя записи
     */
    public  ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName() == key) {
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
        Item result = new Item();
        for (Item item : items) {
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

}
