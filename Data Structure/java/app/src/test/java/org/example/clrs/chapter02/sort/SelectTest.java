package org.example.clrs.chapter02.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SelectTest {
    @Test
    public void selectSortTest() {
        int[] insertionSort = Select.selectionSort(new int [] {5, 3, 2, 4, 4, 7, 1, 2});
        assertArrayEquals(insertionSort, new int [] {1, 2, 2, 3, 4, 4, 5, 7});
    }
}
