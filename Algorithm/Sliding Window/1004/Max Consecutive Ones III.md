**Example 1:**
```
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```
**Example 2:**
```
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```

先跑 j，同時用 zero 計算 0，當 zero 大於 k 時跑 i，讓 i 跑到可讓 zero 維持到 k 的 0。這樣透過 j- i + 1 即可獲取在 k 個 0 進行反轉後可以獲得最大的長度。
```java
# https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int longestOnes(int[] nums, int k) {
        int j = 0;
        int i = 0;
        int n = nums.length;
        int zero = 0;
        int maxCount = 0;
        while( j < n) {
            if (nums[j] == 0){
                zero++;
                if (zero > k) {
                    while(nums[i] != 0) {
                        i++;
                    }
                    i++;
                    zero--;
                }
            }
            maxCount = Math.max(maxCount, j - i + 1);
            j++;
        }
        return maxCount;
    }
}
```
