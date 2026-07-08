---
title: "Find Numbers with Even Number of Digits"
date: 2026/07/07
tags: ["array"]
draft: false
---

# 1295. Find Numbers with Even Number of Digits

Given an array `nums` of integers, return how many of them contain an **even number** of digits.
##### Example 1:
```
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
```
##### Example 2:
```
Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
``` 

##### Constraints:

- `1 <= nums.length <= 500`
- `1 <= nums[i] <= 105`


## Solution

**java**

case01: 將數字轉為字串，檢查長度是否為偶數。

```java
class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            var str = String.valueOf(num)   ;
            if (str.length() % 2 == 0) {
                result++;
            }
        }
        
        return result;
    }
}
```

Time Complexity: `O(n)`
Space Complexity: `O(1)`


case02: 使用數學方法計算位數。


```java
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int len = digitLen(num);
            if (len % 2 == 0) {
                res++;
            }
        }
        return res;
    }
    
    public int digitLen(int num) {
        int length = 0;
        while (num != 0) {
            num = num/10;
            length++;
                
        }
        return length;
    }
}
```

**go**

```go
func findNumbers(nums []int) int {
    res := 0
    for _, v := range nums {
        if digitLen(v)%2 == 0 {
            res++
        }
    }
    return res
}

func digitLen(num int) int {
    lens := 0
    for num > 0 {
        lens++
        num /= 10
    }
    return lens
}
```