---
title: "Replace Elements with Greatest Element on Right Side"
date: 2026/07/09
tags: ["array", "In-Place"]
draft: false
---

Given an array `arr`, replace every element in that array with the greatest element among the elements to its right, and replace the last element with `-1`.

After doing so, return the array.

**Example 1:**
```
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
```
**Example 2:**
```
Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.
``` 

**Constraints:**

- 1 <= `arr.length` <= $10^4$
- 0 <= `arr[i]` <= $10^5$

## Solution

把陣列中的每一個數字，換成它「右手邊所有數字裡面的最大值」；而陣列的最後一個元素，因為右邊沒有任何人了，所以題目規定一律填上 -1。

從範例一，我們可以從左到右來看每個位置該怎麼換：
- `arr[0] = 17`：右邊有 `[18, 5, 4, 6, 1]`，最大值是 `18 $\rightarrow$` 變成 `18`
- `arr[1] = 18`：右邊有 `[5, 4, 6, 1]`，最大值是 `6 $\rightarrow$` 變成 `6`
- `arr[2] = 5` ：右邊有 `[4, 6, 1]`，最大值是 `6 $\rightarrow$` 變成 `6`
- `arr[3] = 4`：右邊有 `[6, 1]`，最大值是 `6 $\rightarrow$` 變成 `6`
- `arr[4] = 6`：右邊有 `[1]`，最大值是 `1 $\rightarrow$` 變成 `1`
- `arr[5] = 1`：右邊沒有人，固定變成 `-1`

最後輸出的結果為：`[18, 6, 6, 6, 1, -1]`


**java**

```java
class Solution {
    public int[] replaceElements(int[] arr) {
        int soFar = -1;
        for (int i = arr.length - 1; i >= 0; i-- ) {
            int currVal = arr[i];
            arr[i] = soFar;
            soFar = Math.max(currVal, soFar);
        }

        return arr;
    }
}
```
