---
title: "Kth Largest Element in an Array"
date: 2026/07/30
tags: ["Sorting", "Heap Sort"]
draft: false
---

given an integer array `nums` and an integer `k`, return the `k-th` largest element in the array.
Note that it is the `k-th` largest element in the sorted order, not the `k-th` distinct element.
Can you solve it without sorting?

**Example 1:**
```
Input: `nums = [3,2,1,5,6,4]`, `k = 2`
Output: `5`
```

**Example 2:**
```
Input: `nums = [3,2,3,1,2,4,5,5,6]`, `k = 4`
Output: `4`
```

**Constraints:**
- `1 <= k <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

## Solution

給一個未排序的整數陣列 `nums` 和一個整數 `k`，請找出陣列中排序後第 `k` 個最大的元素。

**java**

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
```

使用最小堆疊（Min-Heap），逐一將數字塞入 Min-Heap 中。一旦堆疊大小超過 `k`，就把最小的（堆疊頂端 root）踢出去。走完陣列後，堆疊裡留下的就是前 `k` 大的數字，而位於頂端的 root 恰好就是第 `k` 大的數字。

**Complexity Analysis**
* Time Complexity: $O(N \log k)$
    * 陣列共有 $N$ 個元素，每次往容量為 $k$ 的 `PriorityQueue` 插入與刪除節點的時間是 $O(\log k)$。
* Space Complexity: $O(k)$
    * 只需要一個大小固定為 $k$ 的堆疊空間。