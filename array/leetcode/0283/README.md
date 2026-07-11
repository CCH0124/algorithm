---
title: "Move Zeroes"
date: 2026/07/10
tags: ["Array", "Two Pointers"]
draft: false
---

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

**Example 1:**
```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```
**Example 2:**
```
Input: nums = [0]
Output: [0]
``` 

**Constraints:**

- 1 <= `nums.length` <= $10^4$
- -2^31 <= `nums[i]` <= 2^31 - 1

## Solution


### Case1
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        while(index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
```


當全都是非 0 數字時（例如 [1,2,3,4]），除了 for 要原地寫入 4 次，while 不會執行。但若全都是 0（例如 [0,0,0,0]），while 會平白寫入 4 次。

**Complexity**

* **Time Complexity**: `O(n)`
    * 陣列中的每個元素最多都只會被掃描過一次
* **Space Complexity**: `O(1)`
    * 只額外宣告了幾個整數變數(index)，沒有使用額外的陣列或記憶體空間。


### Case2

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    
                }
                index++;
            }
        }
    }
}
```

加上 `if (i != index)` 判斷後，若全都是非 0 或全都是 0，完全不會發生任何寫入（Swap）動作。你可以把 `i` 想像成先鋒，負責找出不是 0 的數字；而 `index` 則是守門員，守在前面準備填入非 0 數字的位置。如果 `i` 和 `index` 重疊了，就代表前面沒有 0，不需要做任何多餘的搬動操作。

**Complexity**

* **Time Complexity**: `O(n)`
    * 陣列中的每個元素最多都只會被掃描過一次
* **Space Complexity**: `O(1)`
    * 只額外宣告了幾個整數變數(index)，沒有使用額外的陣列或記憶體空間。


#### 圖解雙指針交換過程

初始狀態：`index = 0`，`i = 0`
陣列狀態：`[ 0, 1, 0, 3 ]`

##### 第一步：`i = 0`

* `nums[0]` 是 `0`
* 條件不成立，`index` 守在原地不動，`i` 繼續往前走。
* 陣列維持：`[ 0, 1, 0, 3 ]`
* *(此時 index 守在第 0 格，i 走到第 1 格)*

---

##### **第二步：i = 1**

* `nums[1]` 是 `1`（不是 0，觸發交換！）
* 檢查 `i != index` (`1 != 0` 成立)，所以將 `nums[1]` 和 `nums[0]` 交換。
* **交換後**：陣列變成 `[ 1, 0, 0, 3 ]`
* `index` 功成身退，往前進一格（`index = 1`）。
* *(此時 index 守在第 1 格，i 走到第 2 格)*

---

##### **第三步：i = 2**

* `nums[2]` 是 `0`
* 條件不成立，`index` 守在原地不動，`i` 繼續往前走。
* 陣列維持：`[ 1, 0, 0, 3 ]`
* *(此時 index 守在第 1 格，i 走到第 3 格)*

---

##### **第四步：i = 3**

* `nums[3]` 是 `3`（不是 0，觸發交換！）
* 檢查 `i != index` (`3 != 1` 成立)，所以將 `nums[3]` 和 `nums[1]` 交換。
* **交換後**：陣列變成 `[ 1, 3, 0, 0 ]`
* `index` 往前進一格（`index = 2`）。

---

##### 結束

`for` 迴圈跑完了，此時陣列已經完美變成 `[ 1, 3, 0, 0 ]`。


在第二步和第四步的*交換*過程中：

* 我們把非 0 的數字（`1` 和 `3`）移到前面的同時。
* 原本前面的 `0` 就**順便被換到後面去了**。

這就是為什麼我們不需要像像 case1 的寫法那樣，最後還要用一個 `while` 迴圈去把後面苦苦補上 `0`。透過一前一後的雙指針，`0` 自然而然就會被搬到陣列的末端。