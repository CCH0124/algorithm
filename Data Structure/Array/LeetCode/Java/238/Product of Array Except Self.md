**Example 1:**
```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```
**Example 2:**
```
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
```


```java
# 一開始想法，全部數值相乘。但如果有 0 就會有問題。
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res = 1;

        for (int n : nums) {
            res *= n;
        }

        for (int i=0; i<nums.length; i++){
            nums[i] = res/nums[i];
        }

        return nums;
    }
}
```

```java
# https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
# https://youtu.be/bNvIQI2wAjk?si=XuQSEE756kwUINIF
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int prefix = 1;

        for (int i = 0; i< n; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = postfix * ans[i];
            postfix *= nums[i];
        }

        return ans;
    }
}
```
