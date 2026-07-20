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

```java
class Solution {
    public void sortColors(int[] nums) {
        int minIndex;
        for (int i = 0; i<nums.length; i++) {
            minIndex = i;
            for (int j = i+1; j<nums.length; j++) {
                if (nums[minIndex] > nums[j] ) {
                    minIndex = j;
                }
            }
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