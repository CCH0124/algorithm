---
title: "Sort an Array"
date: 2026/07/20
tags: ["Sorting", "Heap Sort"]
draft: false
---

Given an array of integers `nums`, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in $O(n\log(n))$ time complexity and with the smallest space complexity possible.

**Example 1**

```
**Input**: `nums = [5,2,3,1]`
**Output**: `[1,2,3,5]`
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
```

**Example 2**

```
**Input**: `nums = [5,1,1,2,0,0]`
**Output**: `[0,0,1,1,2,5]`
Explanation: Note that the values of nums are not necessarily unique.
```

**Constraints**

* $1 \le n \le 5 \cdot 10^4$
* $-5 \cdot 10^4 \le nums[i] \le 5 \cdot 10^4$

## Solution

**java**

```java
class Solution {
    public int[] sortArray(int[] nums) {
        // 將陣列進行堆化
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, nums.length, i);
        }
        // 對堆化資料進行排序
        for (int i = nums.length - 1; i > 0; i--) {
            // swap last element with first element
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            // note that we reduce the heap size by 1 every iteration
            maxHeapify(nums, i, 0);
        }
        return nums;
    }
    private void maxHeapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }  
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, heapSize, largest);
        }
    }
}
```

**Complexity**

* **Time Complexity**: $O(n\log(n))$
* **Space Complexity**: $O(1)$
```