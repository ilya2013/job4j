package ru.job4j.iterator;

import java.util.Iterator;

public class IteratorOfIterators {
    public class Converter {
        Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return false;
                }
                @Override
                public Integer next() {
                    return null;
                }
            };
        }
    }
}
