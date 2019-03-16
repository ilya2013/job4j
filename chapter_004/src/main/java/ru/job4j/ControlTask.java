package ru.job4j;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ControlTask {
    protected int convert(List<Integer> list) {
        return list.stream()
                .filter(e -> (e != null && e % 2 == 0))
                .map(e -> e * e)
                .reduce(0, (e1, e2) -> e1 + e2);
    }
}
