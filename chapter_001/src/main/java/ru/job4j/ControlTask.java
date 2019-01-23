package ru.job4j;

import java.util.Arrays;

public class ControlTask {
    public  int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
         int indA = 0;
         int indB = 0;
         int indR = 0;
        while (indA < a.length && indB < b.length) {
            result[indR++] = a[indA] <= b[indB] ? a[indA++] : b[indB++];
        }
        if (indA >= a.length) {
            System.arraycopy(b, indB, result, indR, b.length - indB);
        } else {
            System.arraycopy(a, indA, result, indR, a.length - indA);
        }
        return result;
    }
}

