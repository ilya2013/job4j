package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1 ;
        int[][] array = new int[rows][cells = cells == 0 ? 1 : cells];
        int idx = 0;
        for (Integer element : list) {
            array [idx / cells][idx % cells] =  element;
            idx++;
        }
        return array;
    }
}