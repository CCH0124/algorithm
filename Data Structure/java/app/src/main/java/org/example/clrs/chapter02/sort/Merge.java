package org.example.clrs.chapter02.sort;

public class Merge {
    public static int countInversions(int[] arr, int left, int right) {
        if (left >= right) return 0;
        int middle = (left + right) / 2;
        var l = countInversions(arr, left, middle);
        var r = countInversions(arr, middle + 1 , right);
        return l + r + mergeCountInversions(arr, left, middle, right);

    }

    public static int mergeCountInversions(int[] arr, int left, int mid, int right) {
        int l = mid - left + 1;
        int r = right - mid;
        int[] leftTemp = new int[l];
        int[] rightTemp = new int[r];
        for (int i = 0; i < l; i++) {
            leftTemp[i] = arr[left + i];
        }
        for (int i = 0; i < r; i++) {
            rightTemp[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int inversions = 0;
        int k = left;
        while (i < l && j < r) {
            if (leftTemp[i] <= rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            } else {
                arr[k] = rightTemp[j];
                j++;
                inversions += (l - i);
            }
            k++;
        }
        // 複製左半邊剩餘的元素
        while (i < l) {
            arr[k] = leftTemp[i];
            i++;
            k++;
        }
        // 複製右半邊剩餘的元素
        while (j < r) {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
        
        return inversions;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // 遞迴排序左半邊
            mergeSort(arr, left, middle);

            // 遞迴排序右半邊
            mergeSort(arr, middle + 1, right);

            // 合併兩個已排序的子陣列
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = mid - left + 1;
        int r = right - mid;
        int[] leftTemp = new int[l];
        int[] rightTemp = new int[r];
        for (int i = 0; i < l; i++) {
            leftTemp[i] = arr[left + i];
        }
        for (int i = 0; i < r; i++) {
            rightTemp[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < l && j < r) {
            if (leftTemp[i] <= rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            } else {
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }
        // 複製左半邊剩餘的元素
        while (i < l) {
            arr[k] = leftTemp[i];
            i++;
            k++;
        }

        // 複製右半邊剩餘的元素
        while (j < r) {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
    }
}
