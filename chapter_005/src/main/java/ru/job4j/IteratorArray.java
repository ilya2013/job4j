package ru.job4j;

import java.util.Iterator;

public class IteratorArray<Integer> implements Iterator<Integer> {

private final Integer[] array;
private int indx = 0;
    public IteratorArray(Integer[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return indx < array.length;
    }

    @Override
    public Integer next() {
        return this.array[indx++];
    }
}
