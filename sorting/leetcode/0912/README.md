---
title: "Sort an Array"
date: 2026/07/20
tags: ["Sorting", "Heap Sort"]
draft: false
---

Given an array of integers `nums`, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in $O(n\log(n))$ time complexity and with the smallest space complexity possible.

**Example 1**

```
**Input**: `nums = [5,2,3,1]`
**Output**: `[1,2,3,5]`
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
```

**Example 2**

```
**Input**: `nums = [5,1,1,2,0,0]`
**Output**: `[0,0,1,1,2,5]`
Explanation: Note that the values of nums are not necessarily unique.
```

**Constraints**

* $1 \le n \le 5 \cdot 10^4$
* $-5 \cdot 10^4 \le nums[i] \le 5 \cdot 10^4$

## Solution

**java**

```java
class Solution {
    public int[] sortArray(int[] nums) {
        // 將陣列進行堆化
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, nums.length, i);
        }
        // 對堆化資料進行排序
        for (int i = nums.length - 1; i > 0; i--) {
            // swap last element with first element
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            // note that we reduce the heap size by 1 every iteration
            maxHeapify(nums, i, 0);
        }
        return nums;
    }
    private void maxHeapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }  
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, heapSize, largest);
        }
    }
}
```

**Complexity**

* **Time Complexity**: $O(n\log(n))$
* **Space Complexity**: $O(1)$

**go**

```go
func sortArray(nums []int) []int {
    n := len(nums)
	if n <= 1 {
		return nums
	}

	for i := n/2 - 1; i >= 0; i-- {
		heapify(nums, n, i)
	}

	for i := n - 1; i > 0; i-- {
		// 將目前的樹頂（最大值 nums[0]）換到陣列末端
		nums[0], nums[i] = nums[i], nums[0]

		// 對剩下的 i 個元素進行 heapify，讓新的樹頂下沉
		heapify(nums, i, 0)
	}

	return nums
}

func heapify(nums []int, size int, i int) {
    left := 2 * i + 1
    right := 2 * i + 2
    largest := i
    if left < size && nums[left] > nums[largest] {
        largest = left
    }
    if right < size && nums[right] > nums[largest] {
        largest = right
    }
    
    if largest != i {
        temp := nums[i]
        nums[i] = nums[largest]
        nums[largest] = temp
        heapify(nums, size, largest)
    }
}
```

## 圖解

heapify 的「連鎖下沉」過程，假設我們現在對索引 0 的爸爸 [3] 執行 heapify(arr, size=5, i=0)。
陣列現況：[3, 10, 8, 5, 6]

```
【 步驟 1：比對家庭內部成員 】

        [ 3 ]  <-- 索引 i = 0 (爸爸)
       /     \
   [ 10 ]   [ 8 ]  <-- 索引 left=1, right=2
   /    \
 [5]    [6]

 程式執行邏輯：
 1. 初始假設 largest = 0 (數值 3)
 2. 比較左兒子 10 > 3 成立 -> largest 改標記為 1 (左兒子)
 3. 比較右兒子 8 > 10 不成立
 4. 判定 largest != 0，確定「爸爸被篡位了」！
-------------------------------------------------------------------------

【 步驟 2：進行第一層交換 (Swap) 】

        [ 10 ]  <-- 10 順利上台當爸爸
       /      \
    [ 3 ]    [ 8 ]  <-- 3 被換到了索引 largest = 1 的位置！
   /    \
 [5]    [6]

 陣列變成：[ 10, 3, 8, 5, 6 ]
-------------------------------------------------------------------------

【 步驟 3：連鎖反應！對新家遞迴執行 heapify(arr, 5, largest=1) 】

 3 被換到新位置後，我們必須關注以他為首的「新小家庭」：

        [ 10 ]
       /      \
    [ 3 ]     [ 8 ]   <-- 新的爸爸，索引 i = 1
   /     \
 [5]     [6]          <-- 新的兒子們，索引 left=3 (值5), right=4 (值6)

 程式執行邏輯：
 1. 初始假設 largest = 1 (數值 3)
 2. 比較左兒子 5 > 3 成立 -> largest 改標記為 3
 3. 比較右兒子 6 > 5 成立 -> largest 改標記為 4 (右兒子)
 4. 判定 largest != 1，發現 3 在這裡依然太小，必須再次交換！
-------------------------------------------------------------------------

【 步驟 4：進行第二層交換與停止條件 】

        [ 10 ]
       /      \
    [ 6 ]     [ 8 ]   <-- 6 升官上來
   /     \
 [5]     [ 3 ]        <-- 3 繼續沉到了索引 4 的位置

 陣列變成：[ 10, 6, 8, 5, 3 ]

 接下來程式會執行：heapify(arr, 5, largest=4)
 但因為索引 4 已經沒有任何兒子了 (left = 2*4+1 = 9 >= size 5)，
 所有的 if 條件都不會成立，`largest == i` 成立，【遞迴停止】！
```