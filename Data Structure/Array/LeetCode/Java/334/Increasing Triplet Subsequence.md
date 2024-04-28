
**Example 1:**
```
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
```
**Example 2:**
```
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
```
**Example 3:**
```
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
```

從陣列順序的迭代中，找出前三可以由小至大的數值。以符合題目 i, j, k 索引順序。
```java
# https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int x=0; x<nums.length; x++){
            if (nums[x] <= i) {
                i = nums[x];
            } else if (nums[x] <= j ) {
                j = nums[x];
            } else {
                return true;
            }
        }

        return false;
    }
}
```

```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int x=0; x<nums.length; x++){
            if (nums[x] <= i) {
                i = nums[x];
            } else if (nums[x] >= i && nums[x] <= j ) {
                j = nums[x];
            } 
            if (nums[x] > j){
                return true;
            }
        }

        return false;
    }
}
```
