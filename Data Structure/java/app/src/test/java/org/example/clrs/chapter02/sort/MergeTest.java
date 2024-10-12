package org.example.clrs.chapter02.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeTest {
    @Test
    public void mergeSortTest() {
        var init = new int [] {5, 3, 2, 4, 4, 7, 1, 2};
        Merge.mergeSort(init, 0, init.length - 1);
        assertArrayEquals(init, new int [] {1, 2, 2, 3, 4, 4, 5, 7});
    }
}
