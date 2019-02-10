package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int n1 = left.length();
        int n2 = right.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = left.charAt(i);
            char c2 = right.charAt(i);
            if (Character.compare(c1, c2) != 0) {
                        return Integer.compare(c1, c2);
            }
        }
        return Integer.compare(n1, n2);
    }
}