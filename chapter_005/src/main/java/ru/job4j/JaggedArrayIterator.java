package ru.job4j;

import java.util.Iterator;

public class JaggedArrayIterator<Integer> implements Iterator<Integer> {
    private final IteratorArray[] iteratorArrayArray;
    private int indx = 0;

    public JaggedArrayIterator(Integer[][] array) {
        iteratorArrayArray = new IteratorArray[array.length];
        for (int i = 0; i < array.length; i++) {
            iteratorArrayArray[i] = new IteratorArray(array[i]);
        }
    }

    @Override
    public boolean hasNext() {
        return indx < iteratorArrayArray.length - 1 || iteratorArrayArray[indx].hasNext();
    }

    @Override
    public Integer next() {
        Integer result;
        if (iteratorArrayArray[indx].hasNext()) {
            result = (Integer) iteratorArrayArray[indx].next();
        } else {
              result = (Integer) iteratorArrayArray[++indx].next();
        }
        return result;
    }
}
