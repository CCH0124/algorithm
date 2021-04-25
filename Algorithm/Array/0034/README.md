There is an integer array `nums` sorted in ascending order (with **distinct** values).

Prior to being passed to your function, nums is **rotated** at an unknown pivot index `k (0 <= k < nums.length)` such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` **after** the rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.

**Example 1:**
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```
**Example 2:**
```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```
**Example 3:**
```
Input: nums = [1], target = 0
Output: -1
```
 

**Constraints:**

- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- All values of `nums` are **unique**.
- `nums` is guaranteed to be rotated at some pivot.
- `-10^4 <= target <= 10^4`
 

**Follow up:** Can you achieve this in `O(log n)` time complexity?

這是一個搜尋問題，簡單點使用一個迴圈進行迭代就可以完成，但是題目希望達到 `O(log n)` 因此需要往二元搜尋去思考，這過程增加了中間值、左指標、右指標和目標值如何移動。

java

以 [4,5,6,7,0,1,2] 為例，mid 值為 `7`，但目標是要找 `0`。以正常二元搜尋條件來看是無法正確執行，因此需要使用 mid、left 和 right 的索引值來進行移動，`nums[left] <= nums[mid]` 用於表示一個區間，`nums[right] >= nums[mid]` 是另一個區間。接著在各區間內寫 left、和 right 的邏輯。

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while( left <= right ){
            int mid = (left+right)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid]){
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;    
                } else {
                    left = mid + 1;
                }
            } else if (nums[right] >= nums[mid]){
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
```