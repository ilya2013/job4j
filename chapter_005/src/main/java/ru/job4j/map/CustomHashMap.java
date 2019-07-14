package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomHashMap<K, V> {

    private CustomHashMap.Entry<K, V>[] table;

    private int size;

    private int modCount;

    public CustomHashMap(int initialCapacity) {
        this.table = new CustomHashMap.Entry[initialCapacity];
    }

    /**
     * Вставка.
     * @param key   Ключ.
     * @param value Значение.
     * @return true или false.
     */
    public boolean insert(K key, V value) {
        if (this.size == this.table.length) {
            doubleAndRehash();
        }
        int index = getHash(key) % table.length;
        CustomHashMap.Entry entry = table[index];
        if (entry != null) {
            if (key.equals(entry.getKey())) {
                entry.setValue(value);
                return true;
            } else {
                return false;
            }
        }
        this.table[index] = new Entry(key, value);
        this.size++;
        this.modCount++;
        return true;
    }

    /**
     * Получить элемент по ключу.
     *
     * @param key Ключ.
     * @return Значение.
     */
    public V get(K key) {
        Entry<K, V> entry = this.table[getHash(key) % this.table.length];
        if (entry != null && key.equals(entry.getKey())) {
            return entry.getValue();
        }
        return null;
    }

    /**
     * Удалить по ключу.
     *
     * @param key Ключ.
     * @return true или false.
     */
    public boolean delete(K key) {
        int id = getHash(key) % this.table.length;
        CustomHashMap.Entry<K, V> entry = this.table[id];
        if (entry != null && key.equals(entry.getKey())) {
            this.table[id] = null;
            this.size--;
            this.modCount++;
            return true;
        }
        return false;
    }

    private void doubleAndRehash() {
        int newCapacity = this.table.length == 0 ? 1 : this.table.length * 2;
        CustomHashMap.Entry<K, V>[] newTable = new CustomHashMap.Entry[newCapacity];
        for (CustomHashMap.Entry entry : this.table) {
            newTable[getHash(entry.getKey()) % newTable.length] = entry;
        }
        this.table = newTable;
    }

    private int getHash(Object key) {
        int hash = key == null ? 0 : key.hashCode();
        return hash < 0 ? -hash : hash;
    }

    public Iterator<CustomHashMap.Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private int index;

            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                while (index < table.length) {
                    if (table[index] != null) {
                        return true;
                    }
                    index++;
                }
                return false;
            }

            @Override
            public Entry<K, V> next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++];
            }
        };
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
