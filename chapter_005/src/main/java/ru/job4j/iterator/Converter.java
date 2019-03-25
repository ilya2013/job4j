package ru.job4j.iterator;

import java.util.Iterator;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        int ind = 0;
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                //it.
                //return ;
                return true;
            }
            @Override
            public Integer next() {
                return null;
            }
        };
    }
}
