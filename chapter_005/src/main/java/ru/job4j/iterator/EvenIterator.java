package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] array;
    private int id;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i = id; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                res = true;
                id = i;
                break;
            }
        }
        return res;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[id++];
    }
}
