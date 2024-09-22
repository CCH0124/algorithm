package org.example.clrs.chapter02.sort;
import java.util.Arrays;

public class Insert {
    public static int[] insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int up = arr[i];
            int j = i; // If we get smaller value than valueToSort then , we stop at that index.
            while (j > 0 && arr[j - 1] > up) {
                arr[j] = arr[j - 1];
                j--;
            }

            // We will put valueToSort at that index
            arr[j] = up;

            System.out.print((i) + ": ");
            System.out.println(Arrays.toString(arr));
        }

        return arr;
    }
}
