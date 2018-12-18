package ru.job4j.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"a", "a", "b", "b", "c", "a"};
        String[] result = arrayDuplicate.remove(array);
        String[] expected = {"a", "c", "b"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }


    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] array = {"a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
        String[] result = arrayDuplicate.remove(array);
//        System.out.println(result.length + ": ");
        String[] expected = {"a", };
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}