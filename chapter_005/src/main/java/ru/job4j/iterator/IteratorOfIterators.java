package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;


public class IteratorOfIterators {
    private Iterator<Integer> innerIterator;
    protected Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                boolean result = false;
                    while (it.hasNext()) {
                        if (innerIterator != null && innerIterator.hasNext()) {
                            break;
                        } else {
                            innerIterator = it.next();
                        }
                    }
                    result = innerIterator != null && innerIterator.hasNext();
                return result;
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
