package org.example.clrs.chapter02.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MergeTest {
    @Test
    public void mergeSortTest() {
        var init = new int [] {5, 3, 2, 4, 4, 7, 1, 2};
        Merge.mergeSort(init, 0, init.length - 1);
        assertArrayEquals(init, new int [] {1, 2, 2, 3, 4, 4, 5, 7});
    }

    @Test
    public void mergeCountInversionsTest() {
        var init = new int [] {2, 3, 8, 6, 1};
        var init2 = new int [] {4, 3, 2, 1};
        var init3 = new int [] {2, 4, 1, 3, 5};
        var init4 = new int [] {2, 3, 4, 5, 6};
        int countInversions = Merge.countInversions(init, 0, init.length - 1);
        int countInversions2 = Merge.countInversions(init2, 0, init2.length - 1);
        int countInversions3 = Merge.countInversions(init3, 0, init3.length - 1);
        int countInversions4 = Merge.countInversions(init4, 0, init4.length - 1);
        assertEquals(5, countInversions);
        assertEquals(6, countInversions2);
        assertEquals(3, countInversions3);
        assertEquals(0, countInversions4);
    }
}
