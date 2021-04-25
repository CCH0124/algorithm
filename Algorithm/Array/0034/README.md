Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

**Follow up:** Could you write an algorithm with `O(log n)` runtime complexity?

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
 

**Constraints:**

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- nums is a non-decreasing array.
- `-10^9 <= target <= 10^9`


java

下面是最簡單方式，題目是說要找到目標值的最前面和最後面的索引，因此可以使用從前到後和從後到前迴圈方式找出答案，但這是並不是題目想要的結果。

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1){
            return new int[]{-1,-1};    
        }
        int i = 0;
        while ( i < nums.length && nums[i] != target) {
             i++;
        }
        int j = nums.length - 1;
        while( j >= 0 && nums[j] != target){
            j--;
        }
        if ( i > nums.length || j < 0){
            return new int[]{-1,-1};    
        }
        return new int[]{i, j};
    }
}
```

下面解法就是利用二元搜尋找到目標值，在藉由該目標值的索引往左和往右走，這樣就可以找到最前面和最後面的目標值。

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                right = mid;
                while(mid >= 0 && nums[mid] == target){
                    mid--;
                }
                while(right < nums.length && nums[right] == target){
                    right++;
                }
                return new int[]{mid+1, right-1};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
```