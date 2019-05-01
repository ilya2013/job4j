package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int position = -1;
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) throws TooManyElements {
        if (position == this.array.length - 1) {
            throw new TooManyElements();
        }
        array[++position] = model;
    }


    public void set(int index, T model) {
        if (index < 0 || index > position) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = model;
    }

    public void remove(int index) {
        if (index < 0 || index > position) {
            throw new IndexOutOfBoundsException();
        }
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            position--;
    }

    public <T> T get(int index) {
        return index >= 0 && index <= position ? (T) array[index] : null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index <= position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[index++];
            }
        };
    }
}
