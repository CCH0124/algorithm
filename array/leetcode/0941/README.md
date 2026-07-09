---
title: "Valid Mountain Array"
date: 2026/07/08
tags: ["Array","Two Pointers"]
draft: false
---

Given an array of integers `arr`, return *`true` if and only if it is a valid mountain array*.

Recall that arr is a mountain array if and only if:

- `arr.length >= 3`
- There exists some `i` with `0 < i < arr.length - 1` such that:
  - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
  - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

![](https://assets.leetcode.com/uploads/2019/10/20/hint_valid_mountain_array.png)

**Example 1:**
```
Input: arr = [2,1]
Output: false
```
**Example 2:**
```
Input: arr = [3,5,5]
Output: false
```
**Example 3:**
```
Input: arr = [0,3,2,1]
Output: true
``` 

**Constraints:**

- `1 <= arr.length <= 104`
- `0 <= arr[i] <= 104`


## Solution

題目會給你一個整數陣列 arr，要你判斷這個陣列的數字走向，形狀是不是剛好符合一座單峰山脈。須滿足以下兩個條件

1. 嚴格遞增後，嚴格遞減
    陣列的元素必須先**只升不降**地爬到最高點（山頂），再**只降不升**地走下山。

2. 不能是平地或單向坡


```java
class Solution {
    public boolean validMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        // 左指針爬坡
        while(l + 1 < arr.length && arr[l] < arr[l + 1]) {
            l++;
        }
        // 右指針爬坡
        while(r - 1 >= 0 && arr[r] < arr[r - 1]) {
            r--;
        }
        // 兩指針是否相遇
        // 山頂不能在起點
        // 山頂不能在終點
        return l == r && l > 0 && r < arr.length - 1;
    }
}
```

* **Time Complexity**: `O(n)`
    * 陣列中的每個元素最多都只會被掃描過一次
* **Space Complexity**: `O(1)`
    * 只額外宣告了幾個整數變數(l、r)，沒有使用額外的陣列或記憶體空間。