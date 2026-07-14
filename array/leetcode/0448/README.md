---
title: "Find All Numbers Disappeared in an Array"
date: 2026/07/14
tags: ["array", "Hash Table"]
draft: false
---

Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`, return an array of all the integers in the range `[1, n]` that do not appear in `nums`.


**Example 1**:

```
Input: `nums = [4,3,2,7,8,2,3,1]`
Output: `[5,6]`
```

**Example 2**:

```
Input: `nums = [1,1]`
Output: `[2]`
```

**Constraints**:

$n == nums.length$
$1 <= n <= 10^4$
$1 <= nums[i] <= n$

**Follow up**: Could you do it without extra space and in $O(n)$ runtime? You may assume the returned list does not count as extra space.

## Solution

假設輸入陣列為：`nums = [4, 3, 2, 7, 8, 2, 3, 1]`。
* 陣列長度 $n = 8$，所以理論上完整的數字應該是：`[1, 2, 3, 4, 5, 6, 7, 8]`。
* 觀察 nums：
    * 2 出現了兩次
    * 3 也出現了兩次
    * 數一數，發現 5 和 6 根本沒有出現過，答案輸出：[5, 6]
### Case01

**java**

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        
        for (int num : nums) {
            set.add(num);
        }
        for (int i=0; i< nums.length; i++) {
            if (!set.contains(i+1)) {
                res.add(i+1);
            }
        }
        return res;
    }
}
```

**Complexity**

* **Time Complexity**: $O(n)$
* **Space Complexity**: $O(n)$