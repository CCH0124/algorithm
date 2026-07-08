---
title: "Merge Sorted Array"
date: 2026/07/07
tags: ["array", "two pointer"]
draft: false
---

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers m and n, representing the number of elements in `nums1` and nums2 respectively.

Merge `nums1` and nums2 into a single array sorted in **non-decreasing order**.

The final sorted array should not be returned by the function, but instead be stored inside the array `nums1`. To accommodate this, `nums1` has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

**Example 1:**
```
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
```
**Example 2:**
```
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
```
**Example 3:**
```
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
``` 

**Constraints:**

- nums1.length == m + n
- nums2.length == n
- 0 <= m, n <= 200
- 1 <= m + n <= 200
- $-10^9$ <= nums1[i], nums2[j] <= $10^9$


## Solution


### Case01

暴力合併後排序。

**java**

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        n = n - 1;
        while( n >= 0) {
            nums1[m] = nums2[n];
            m++;
            n--;
        }
        Arrays.sort(nums1);
    }
}
```

Complexity Analysis

- **時間複雜度 (Time Complexity)：$O((m + n) \log(m + n))$**
    - 主要由排序演算法決定
- **空間複雜度 (Space Complexity)：$O(\log(m + n))$**
    - 這是由排序演算法所需的遞歸棧空間或輔助空間決定的

### Case02

因為 `nums1` 後半段預留了足夠的空位（補 0 的地方），我們可以使用*從後往前（倒序）*的雙指針解法。每次比較兩個陣列中最大的數，誰大就先塞到 `nums1` 的最後面。

**java**

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m = m - 1;
        n = n - 1;
        
        while( m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                m--;
            } else {
                nums1[index] = nums2[n];
                n--;
            }
            index--;
        }
        
        while(n >= 0) {
            nums1[index] = nums2[n];
            n--;
            index--;
        }
    }
}
```

Complexity Analysis

- **時間複雜度 (Time Complexity)：$O(m + n)$**
    - 因為我們需要遍歷 nums1 和 nums2 中的所有元素一次。
- **空間複雜度 (Space Complexity)：$O(1)$**
    - 因為我們是在原數組 nums1 上進行操作，沒有使用額外的空間。

**go**

```go
func merge(nums1 []int, m int, nums2 []int, n int)  {
    index := m + n - 1
    m = m - 1
    n = n - 1
    for m >= 0 && n >= 0 {
        if nums1[m] > nums2[n] {
            nums1[index] = nums1[m]
            m--
        } else {
            nums1[index] = nums2[n]
            n--
        }
        index--
    }
    
    for n >= 0 {
        nums1[index] = nums2[n]
        n--
        index--
    }
}
```

## 圖解

三個指針來操作：

1. `p1`：指向 `nums1` 有效數字的末端（`m - 1`）。
2. `p2`：指向 `nums2` 的末端（`n - 1`）。
3. `write`：指向 `nums1` 整個陣列的最末端（`m + n - 1`），也就是準備填入最大數的位置。

---

### 圖解走訪

我們以 `nums1 = [1, 2, 3, 0, 0, 0], m = 3`, `nums2 = [2, 5, 6], n = 3` 為範例：

#### 初始狀態

`p1` 指向 3，`p2` 指向 6，`write` 指向最後一格。

```text
位置 index:   0    1    2    3    4    5
nums1:      [ 1,   2,   3,   0,   0,   0 ]
                        ▲              ▲
                        │              │
                        p1           write

nums2:      [ 2,   5,   6 ]
                        ▲
                        │
                        p2

```

#### 步驟 1：比較 3 和 6

* `nums2[p2] (6) > nums1[p1] (3)` $\rightarrow$ 把 **6** 填入 `nums1[write]`。
* `p2` 左移，`write` 左移。

```text
位置 index:   0    1    2    3    4    5
nums1:      [ 1,   2,   3,   0,   0,   6 ]
                        ▲         ▲
                        │         │
                        p1      write

nums2:      [ 2,   5,   6 ]
                   ▲
                   │
                   p2

```

#### 步驟 2：比較 3 和 5

* `nums2[p2] (5) > nums1[p1] (3)` $\rightarrow$ 把 **5** 填入 `nums1[write]`。
* `p2` 左移，`write` 左移。

```text
位置 index:   0    1    2    3    4    5
nums1:      [ 1,   2,   3,   0,   5,   6 ]
                        ▲    ▲
                        │    │
                        p1 write

nums2:      [ 2,   5,   6 ]
              ▲
              │
              p2

```

#### 步驟 3：比較 3 和 2

* `nums1[p1] (3) > nums2[p2] (2)` $\rightarrow$ 把 **3** 填入 `nums1[write]`。
* `p1` 左移，`write` 左移。

```text
位置 index:   0    1    2    3    4    5
nums1:      [ 1,   2,   3,   3,   5,   6 ]
                   ▲    ▲
                   │    │
                   p1 write

nums2:      [ 2,   5,   6 ]
              ▲
              │
              p2

```

#### 步驟 4：比較 2 和 2

* 兩者相等，隨便挑一個。這裡假設挑 `nums2` 的 2 $\rightarrow$ 把 **2** 填入 `nums1[write]`。
* `p2` 減 1 變成 -1，跳出主要迴圈。

```text
位置 index:   0    1    2    3    4    5
nums1:      [ 1,   2,   2,   3,   5,   6 ]
                   ▲
                   │
                 write
         (p1 在 index 1)

```

此時 `nums2` 已經全部安全塞進 `nums1` 了，合併完成！
