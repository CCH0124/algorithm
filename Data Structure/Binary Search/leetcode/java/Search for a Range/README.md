題目：https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/802/

**Example 1:**
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```
**Example 2:**
```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```
**Example 3:**
```
Input: nums = [], target = 0
Output: [-1,-1]
```

1. 找到中間元素
2. 檢查是否 nums[mid] > target 那麼第一個元素會出現在 mid 的左側。因此，將高指針移至 mid – 1
3. 檢查是否 nums[mid] < target 那麼第一個元素會出現在 mid 的右側。因此，將 low 指標移至 mid + 1
4. 如果 arr[mid] == x 那麼這可能是第一個元素。接著從這 mid 為一個點往左與往右查詢


```java
// O(log n) Time
// https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while(l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target) {
                r = mid;
                while(mid >=0 && nums[mid] == target ) {
                    mid--;
                }
                while(r < nums.length && nums[r] == target) {
                    r++;
                }
                return new int[]{mid+1, r-1};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return new int[]{-1, -1};
    }
}
```
