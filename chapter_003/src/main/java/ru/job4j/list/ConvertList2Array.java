package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1 ;
        int[][] array = new int[rows][cells == 0 ? 1 : cells];
        for (int i = 0; i < rows * cells; i++) {
            array [i / cells][i % cells] = i < list.size() ? list.get(i) : 0;
        }
        return array;
    }
}