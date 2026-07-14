---
title: "Third Maximum Number"
date: 2026/07/13
tags: ["Array", "Set", "PriorityQueue"]
draft: false
---

Given an integer array `nums`, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

**Example 1**:
```
Input: `nums = [3,2,1]`
Output: `1`
Explanation:
First distinct maximum is 3.
Second distinct maximum is 2.
Third distinct maximum is 1.
```
**Example 2**:
```
Input: `nums = [1,2]`
Output: `2`
Explanation:
First distinct maximum is 2.
Second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
```
**Example 3**:
```
Input: `nums = [2,2,3,1]`
Output: `1`
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
```
**Constraints**:

$1 <= nums.length <= 10^4$
$-2^31 <= nums[i] <= 2^31 - 1$

## Solution

### Case01



**java**


```java
class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (int i=0; i<nums.length; i++){
            if ((max1 != null && nums[i] == max1) || 
                (max2 != null && nums[i] == max2) || 
                (max3 != null && nums[i] == max3)) {
                continue;
            }
            if (max1 == null || nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 == null || nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (max3 == null || nums[i] > max3) {
                max3 = nums[i];
            } 
        }
        
        return max3 != null ? max3 : max1;
    }
}
```

解決這個邊界問題最優雅的做法，就是把 `int` 改用 `Integer` 物件，物件的預設值可以是 `null`，這樣能百分之百確定，只要是 `null` 就代表還沒有排序過這個值，完美避開數字邊界問題。

**Complexity**

* Time complexity: $O(n)$
* Space complexity: $O(1)$

### Case02

**java**

```java
    public int thirdMax(int[] nums) {
        // 預設就是 Min-Heap（小頂堆，小的數字在最上面）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 用來記錄目前在堆疊裡的數字，防止重複塞入
        Set<Integer> seen = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (seen.contains(num)) {
                continue;
            }
            seen.add(num);
            minHeap.offer(num);
            
            if (minHeap.size() > 3) {
                int removed = minHeap.poll();
                seen.remove(removed);
            }
        }
        
        if (minHeap.size() < 3) {
            while (minHeap.size() > 1) {
                minHeap.poll(); // 不斷踢出較小的，直到只剩下一個最大的
            }
        }
        
        return minHeap.poll();
    }
}
```

**Complexity**

* Time complexity: $O(n)$
    * PriorityQueue 的插入與刪除需要 $\log K$ 的時間（$K$ 為堆疊大小），但因為我們限制堆疊大小最大只有 3，所以每次操作的時間是 $O(\log 3)$
* Space complexity: $O(1)$
    * 最多都只會裝 3 個元素，佔用的記憶體空間是固定且極小的常數