Given an integer array `nums` sorted in **non-decreasing order**, remove some duplicates in-place such that each unique element appears **at most twice**. The **relative order** of the elements should be kept the **same**.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the **first part** of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.

Return `k` after placing the final result in the first `k` slots of `nums`.

Do **not** allocate extra space for another array. You must do this by **modifying the input array** in-place with O(1) extra memory.

**Custom Judge:**
The judge will test your solution with the following code:
```
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```
If all assertions pass, then your solution will be accepted.

**Example 1:**
```
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```
**Example 2:**
```
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
```

**Constraints:**

- `1 <= nums.length <= 3 * 104`
- `-104 <= nums[i] <= 104`
- `nums` is sorted in **non-decreasing** order.


用一個變數計數當前的數字是否有超過兩個，透過雙指針進行遍歷分別是 i 和 j，如果 i 和 j 數值不同時 c 則會歸 0 重新計數，如果當前 c 沒有超過相同數值連續 2 個時做賦值動作。
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int c = 0; 
        for (int j=1; j<nums.length; j++) {
            if (nums[i] == nums[j]) {
                   c++;
               } else {
                   c = 0;
               }
               if (c < 2) {
                   i++;
                   nums[i] = nums[j];       
            }
        }
        return i+1;
    }
}
```

下面的實現少了一個而外紀錄變數，同樣使用雙指針來遍歷， `i<2` 是因為前兩個不管怎樣都符合條件，當索引從 2 開始時會比較第二個索引和往前兩個索引，原則上第二個索引應當大於往前第兩個索引，如果發現一樣時表示不符合原則。
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j=0; j<nums.length; j++) {
            if ( i < 2 || nums[j] > nums[i-2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
```