package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class IteratorOfIterators {
    private Iterator<Integer> innerIterator;
    protected Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                innerIterator = innerIterator == null || (!innerIterator.hasNext() && it.hasNext()) ? it.next() : innerIterator;
                return innerIterator != null && innerIterator.hasNext();
            }
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return innerIterator.next();
            }
        };
    }
}
