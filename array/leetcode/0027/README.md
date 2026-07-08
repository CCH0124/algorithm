---
title: "Remove Element"
date: 2026/07/08
tags: ["array", "two pointers", "Fast and Slow Pointers"]
draft: false
---

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. The order of the elements may be changed. Then return the number of elements in `nums` which are not equal to `val`.

Consider the number of elements in `nums` which are not equal to `val` be `k`, to get accepted, you need to do the following things:

* Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
* Return `k`.

**Custom Judge:**

The judge will test your solution with the following code:

```
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
```

If all assertions pass, then your solution will be accepted.

**Example 1:**
```
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Example 2:**
```
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 1, 4, 0, and 3.
It does not matter what you leave beyond the returned k (hence they are underscores).
```


**Constraints:**

* $0 <= nums.length <= 100$
* $0 <= nums[i] <= 50$
* $0 <= val <= 100$

## Solution

### Case01

快慢指針。

**java**

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}
```

Complexity Analysis:

* **時間複雜度 (Time Complexity)：$O(n)$**
    * `for` 迴圈中的快指針 `i` 從頭到尾老老實實地走過一遍陣列（長度為 $n$）。
* **空間複雜度 (Space Complexity)：$O(1)$**
    * 沒有宣告任何額外的陣列，只有建立一個 index 變數來紀錄慢指針的位置。
    * 是一個非常標準的 In-place（原地）演算法，空間複雜度為 $O(1)$。

### Case02

假設 `nums` = [1, 2, 3, 4, 5, 100]，而你要移除的 `val` = 100（也就是要移除的元素在最後一個，或者陣列中根本很少 `val`）。

* 程式碼會執行：`nums[0]=nums[0], nums[1]=nums[1], nums[2]=nums[2]`...
* 它把前面不需要被移除的元素，自己複製給自己重複寫入了 5 次。如果陣列很大，這會造成很多無謂的寫入（Write）開銷。


當遇到要移除的 `val` 時，我們直接把**陣列最後面一個元素**拉過來覆蓋它，然後把陣列長度縮小一格。這樣一來，前面不需要移除的元素就完全不需要被動到。

**java**

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;   
            }
        }
        
        return right;
    }
}
```