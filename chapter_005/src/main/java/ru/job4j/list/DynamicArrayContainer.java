package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayContainer<E> implements Iterable<E> {
    private int minimalSize = 2;
    private volatile int modCount = 0;
    private int position = -1;
    private Object[] array = new Object[minimalSize];

    public DynamicArrayContainer(int minimalSize) {
        this.minimalSize = minimalSize > 0 ? minimalSize : this.minimalSize;
    }

    public void add(E value) {
        if (position + 1 == array.length) {
            array =  Arrays.copyOf(array, array.length * 2);
        }
        array[++position] = value;
        modCount++;
    }

    public E get(int index) {
        E result = null;
        if (index <= position) {
            result = (E) array[index];
        }
        return result;
    };

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int index = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index <= position;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) array[index++];
            }
        };
    }
}
