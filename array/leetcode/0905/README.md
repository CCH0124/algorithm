---
title: "Sort Array By Parity"
date: 2026/07/11
tags: ["Array", "Two Pointers", "In-place"]
draft: false
---

# 905. Sort Array By Parity

Given an integer array `nums`, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

**Example 1:**
```
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
```
**Example 2:**
```
Input: nums = [0]
Output: [0]
```

**Constraints:**

- 1 <= `nums.length` <= 1000
- 0 <= `nums[i]` <= 5000

## Solution

### Case1


```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;
        
        // Fill even numbers at the beginning
        for(int i=0; i<nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[index] = nums[i];
                index++;
            }
        }
        
        // Fill odd numbers at the end
        for(int i=0; i<nums.length; i++) {
            if (nums[i] % 2 != 0) {
                ans[index] = nums[i];
                index++;
            }
        }
        
        return ans;
    }
}
```

**Complexity**

- Time Complexity: `O(n)`
- Space Complexity: `O(n)`

### Case2

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        
        for(int i=0; i<nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // Even number: put it at the left pointer
                ans[left] = nums[i];
                left++;
            } else {
                // Odd number: put it at the right pointer
                ans[right] = nums[i];
                right--;
            }
        }
        
        return ans;
    }
}
```

再一開始宣告了 `int[] ans = new int[nums.length];`，如果原本的陣列非常大（例如有 10 萬個數字），你就要額外耗費 10 萬個整數的記憶體空間。這使得你的空間複雜度是 $O(N)$。

**Complexity**

- Time Complexity: `O(n)`
- Space Complexity: `O(n)`

### Case3

```java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if (nums[left]%2 == 0) {
                left++;
            } else if (nums[right]%2 == 1) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
```

使用 In-place 的方式解決，不需要宣告額外的陣列。這使得空間複雜度是 $O(1)$。程式碼邏輯如下：

1. `left` 指標從最左邊出發，找不應該在左邊的奇數。
2. `right` 指標從最右邊出發，找不應該在右邊的偶數。
3. 當兩邊都找到目標時，把他們互相交換（Swap），然後各自前進。
4. 直到 `left` 和 `right` 相遇，表示分類完成。

**Complexity**

- Time Complexity: `O(n)`
- Space Complexity: `O(1)`
