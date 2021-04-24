Given an array `nums` of `n` integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example 1:**

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

**Constraints:**

- 3 <= nums.length <= 10^3
- -10^3 <= nums[i] <= 10^3
- -10^4 <= target <= 10^4

這題套用 `3sum` 的概念，只不過更改針對 3 個數字的和對 `target` 距離邏輯判斷。

java

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res)) {
                    res = target - sum;
                } else if(sum < target){
                    left++;
                } else {
                    right--;
                }
            }
            // 表示 target 在 nums 中存在
            if (res == 0) {
                return target;
            }
            
        }
        
        return target - res;
    }
}
```