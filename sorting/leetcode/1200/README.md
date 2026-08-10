---
title: "Minimum Absolute Difference"
date: 2026/08/10
tags: ["Sorting"]
draft: false
---

Given an array of distinct integers `arr`, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair `[a, b]` follows

* `a, b` are from `arr`
* `a < b`
* `b - a` equals to the minimum absolute difference of any two elements in `arr`

**Example 1**

```
**Input**: `arr = [4,2,1,3]`
**Output**: `[[1,2],[2,3],[3,4]]`
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
```

**Example 2**

```
**Input**: `arr = [1,3,6,10,15]`
**Output**: `[[1,3]]`
```

**Example 3**

```
**Input**: `arr = [3,8,-10,23,19,-4,-14,27]`
**Output**: `[[-14,-10],[19,23],[23,27]]`
```

**Constraints**

* `2 <= arr.length <= 10^3`
* `-10^6 <= arr[i] <= 10^6`

## Solution

給定一個元素不重複 include 的整數陣列 `arr`，請找出所有絕對差最小 include 的數對 `[a, b]`，並按照由小到大的順序回傳。

條件限制：

1. 每個數對 `[a, b]` 中，必須滿足 $a < b$。
2. 輸出的數對列表必須按 $a$ 的大小進行升冪排序（從小到大）。

**Java**

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i+1] - arr[i];
            if (minDiff > diff) {
                minDiff = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == minDiff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
```

**Complexity**

* Time Complexity: $O(N \log N)$
* Space Complexity: $O(N)$