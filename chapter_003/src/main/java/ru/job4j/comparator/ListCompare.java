package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int n1 = left.length();
        int n2 = right.length();
        int min = Math.min(n1, n2);
        int rslt = 0;
        for (int i = 0; i < min; i++) {
            char c1 = left.charAt(i);
            char c2 = right.charAt(i);
            if (Character.compare(c1, c2) != 0) {
                rslt = c1 - c2;
                break;
            }
        }
        return rslt != 0 ? rslt : n1 - n2;
    }
}