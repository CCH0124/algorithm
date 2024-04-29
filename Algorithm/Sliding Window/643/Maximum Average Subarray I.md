**Example 1:**
```
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
```
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
**Example 2:**
```
Input: nums = [5], k = 1
Output: 5.00000
```
```java
# https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int baseSum = 0;
        int maxSum = 0;
        int line = nums.length - k;
        for (int i=0; i<k; i++) {
            baseSum += nums[i];
        }
        maxSum = baseSum;
        for(int i=k; i<nums.length; i++) {
            baseSum = baseSum + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, baseSum);     
        }

        return ((double) maxSum / k);
    }
}
```

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] map = new int[nums.length];
        map[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            map[i] = nums[i] + map[i - 1];
        }
        int maxSum = map[k - 1]; 
        for (int i=k; i < nums.length; i++) {
            maxSum = Math.max(maxSum, map[i] - map[i -k]);
        }

        return ((double) maxSum / k);
    }
}
```
