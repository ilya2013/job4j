package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] array;
    private int id = -1;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return getNextEvenElement() != -1;
    }

    @Override
    public Integer next() {
        int ind = getNextEvenElement();
        if (ind != -1) {
            this.id = ind;
        } else {
            throw new NoSuchElementException();
        }
        return array[ind];
    }

    private int getNextEvenElement() {
        int result = -1;
        for (int i = this.id + 1; i < array.length; i++) {
           if  (array[i] % 2 == 0) {
               result = i;
               break;
           }
        }
        return result;
    }
}
