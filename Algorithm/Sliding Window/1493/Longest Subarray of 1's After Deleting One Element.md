**Example 1:**
```
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
```
**Example 2:**
```
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
```
**Example 3:**
```
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
```

```java
#https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int zero = 0;
        int res = 0;
        while(i < n) {
            if (nums[i] == 0) {
                zero++;
            }
            while(zero > 1) {
                if (nums[j] == 0) {
                    zero--;
                }
                j++;
            }
            res = Math.max(res, i - j + 1 - zero); 
            i++;
        }

        return res == n ? res - 1 : res;
        
    }
}
```
