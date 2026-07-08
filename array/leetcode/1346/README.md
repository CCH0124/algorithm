---
title: "Check If N and Its Double Exist"
date: 2026/07/08
tags: ["Array", "Binary Search", "Hash Table"]
draft: false
---

Given an array `arr` of integers, check if there exists two integers `N` and `M` such that `N` is the double of `M` ( i.e. `N = 2 * M`).

More formally check if there exists two indices `i` and `j` such that :

- `i != j`
- `0 <= i, j < arr.length`
- `arr[i] == 2 * arr[j]`


**Example 1:**
```
Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
```
**Example 2:**
```
Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
```
**Example 3:**
```
Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.
```

**Constraints:**

- `2 <= arr.length <= 500`
- `-10^3 <= arr[i] <= 10^3`

## Solution

簡單來說，題目會給你一個整數陣列 arr，它希望你幫忙當個偵探，在陣列裡找看看有沒有任意兩個數字，其中一個數字剛好是另一個數字的「兩倍」。

### Case01

二元搜尋

**java**

```java
class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i<arr.length; i++) {
            int num1 = Arrays.binarySearch(arr, arr[i]);
            int num2 = Arrays.binarySearch(arr, arr[i]*2);
            if (num1 > -1 && num2 > -1 && num2 != i) {
                return true;
            }
        }
        return false;
    }
}
```



* **Time Complexity:** `$O(n \log n)$`
    * 每次迴圈裡，你執行了兩次 Arrays.binarySearch。二分搜尋的時間複雜度是 $O(\log n)$。
    * 迴圈部分的總時間是 $n \times 2 \times \log n$，忽略常數後是 $O(n \log n)$
* **Space Complexity:** `$O(\log n)$` 或 `$O(1)$`
    * 主要取決於 `Arrays.sort` 的內部遞迴堆疊開銷，通常基本型態的快速排序會消耗 $O(\log n)$ 的輔助空間。

### Case02

空間換時間，HashSet 方式。核心思想就像是在點名，我們一邊用一個迴圈看數字，一邊把看過的數字丟進名單（Set）裡。每看到一個新數字，就去名單裡找看看 **"它的兩   倍"** 或 **"它的一半"** 是不是已經出現過了。

**java**

```java
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num*2)) {
                return true;
            }
            if (num % 2 == 0 && set.contains(num/2)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
```

* **Time Complexity:** `$O(n)$`
    * 迴圈遍歷陣列一次，時間複雜度是 $O(n)$。
* **Space Complexity:** `$O(n)$`
    *HashSet 儲存最多 n 個元素，空間複雜度是 $O(n)$。

**go**

```go
func checkIfExist(arr []int) bool {
    set := make(map[int]bool)
    for _, num := range arr {
        if set[num*2] || (num%2 == 0 && set[num/2]) {
			return true
		}
		set[num] = true
    }
    return false
}
```