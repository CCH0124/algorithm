---
title: "Sort Colors"
date: 2026/07/17
tags: ["Sorting"]
draft: false
---

Given an array `nums` containing $n$ objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

**Example 1**

```
**Input**: `nums = [2,0,2,1,1,0]`
**Output**: `[0,0,1,1,2,2]`
```

**Example 2**

```
**Input**: `nums = [2,0,1]`
**Output**: `[0,1,2]`
```

### Constraints

* $n == nums.length$
* $1 \le n \le 300$
* $nums[i]$ is 0, 1, or 2.

**Follow Up**: Could you come up with a one-pass algorithm using only constant extra space?


## Solution

**java**

1. Selection Sort

    ```java
    class Solution {
        public void sortColors(int[] nums) {
            // defined minIndex to track the index of the minimum element in the unsorted part of the array
            int minIndex;
            for (int i = 0; i<nums.length; i++) {
                minIndex = i;
                for (int j = i+1; j<nums.length; j++) {
                    // find the index of the minimum element in the unsorted part of the array
                    if (nums[minIndex] > nums[j] ) {
                        minIndex = j;
                    }
                }
                // swap the minimum element with the current element
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
    ```

    **Complexity**

    * **Time Complexity**: $O(n^2)$
    * **Space Complexity**: $O(1)$


2. Counting Sort

    因為陣列裡的數字固定只有 0、1、2 三種（分別代表紅、白、藍），數值範圍極小（$K = 3$），因此非常適合用 Counting Sort（計數排序） 來解決。

    ```java
    class Solution {
        public void sortColors(int[] nums) {
            int count0 = 0;
            int count1 = 0;
            int count2 = 0;
            for (int num : nums) {
                if (num == 0) {
                    count0++;
                } else if (num == 1) {
                    count1++;
                } else if (num == 2) {
                    count2++;
                }
            }
            
            int index = 0;

            while (count0 > 0) {
                nums[index++] = 0;
                count0--;
            }

            while (count1 > 0) {
                nums[index++] = 1;
                count1--;
            }
            while (count2 > 0) {
                nums[index++] = 2;
                count2--;
            }
        }
    }
    ```

    **Complexity**

    * **Time Complexity**: $O(n)$
        * first time scan to count the frequency of each number, $O(N)$
        * second time scan to fill the array with the counted frequency, $O(N)$
        * total time complexity is $O(N) + O(N) = O(N)$
    * **Space Complexity**: $O(1)$
        * Only three variables are used to store the count of each number, so the space complexity is $O(1)$.