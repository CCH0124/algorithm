---
title: "Max Consecutive Ones"
date: 2026/07/06
tags: ["array"]
draft: false
---

# 485. Max Consecutive Ones

Given a binary array `nums`, return *the maximum number of consecutive 1's* in the array.

##### Example 1:
```
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
```
##### Example 2:
```
Input: nums = [1,0,1,1,0,1]
Output: 2
``` 

##### Constraints:

- `1 <= nums.length <= 105`
- `nums[i]` is either `0` or `1`.


## Solution

先初始化兩個變數 `consecutive` 記錄目前連續 1 的數量，`result` 記錄最大連續 1 的數量。
遍歷陣列，如果是 1，就將 `consecutive` 增加，如果是 0 就將 `consecutive`歸零。

**Java**

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int consecutive = 0;
        int result = 0;
        for(int num : nums) {
            if (num == 1) {
                consecutive++;
            }
            if (num == 0) {
                result = Math.max(result, consecutive);
                consecutive = 0;
            }
        }
        return Math.max(result, consecutive);
    }
}
```

Time Complexity: `O(n)`
Space Complexity: `O(1)`

**Go**

```go
func findMaxConsecutiveOnes(nums []int) int {
    consecutive := 0
    result := 0
    for _, v := range nums {
        if v == 1 {
            consecutive = consecutive + 1
        }
        if v == 0 {
            result = Max(result, consecutive)
            consecutive = 0
        }
        
    }
    return Max(result, consecutive)
}

func Max(x, y int) int {
	if x < y {
		return y
	}
	return x
}
```

Time Complexity: `O(n)`
Space Complexity: `O(1)`


**Python**

```python
class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        consecutive  = 0
        result = 0
        for num in nums:
            if num == 1:
                consecutive += 1
                
            else:
                result = max(result, consecutive)
                consecutive = 0
        return max(result, consecutive)

```

Time Complexity: `O(n)`
Space Complexity: `O(1)`