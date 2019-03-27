package ru.job4j.iterator.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) throws TooManyElements {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = model;
                result = true;
                break;
            }
        }
        if (!result) {
            throw new TooManyElements();
        }
    }

    public boolean set(int index, T model) {
        boolean result = false;
        if (index < array.length && array[index] != null) {
            array[index] = model;
            result = true;
        }
        return result;
    }

    public void remove(int index) {
//       if (index < array.length && array[index] != null) {
//           System.arraycopy(array, index + 1, array, index, array.length - index - 1);
//       }
        if (index < array.length && array[index] != null) {
            for (int ind = index; ind < array.length; ind++) {
                array[ind] = ind < array.length - 1 ? array[ind + 1] : null;
            }
        }

    }

    public <T> T get(int index) {
        return index < array.length ? (T) array[index] : null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < array.length && array[index] != null;
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
