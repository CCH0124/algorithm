**Example 1:**
```
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

```java
# https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/809/
# https://www.geeksforgeeks.org/java-program-for-coin-change/
class Solution {
    public int coinChange(int[] coins, int amount) {
        return minCoin(amount, coins, new HashMap<>());
    }
    
    public int minCoin(int amount, int[] coins, HashMap<Integer, Integer> memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        
        if (memo.containsKey(amount)) return memo.get(amount);
        
        int minCoins = -1;
        
        for (int coin: coins) {
            int subCoin = minCoin(amount - coin, coins, memo);
            if (subCoin != -1) {
                int res = subCoin + 1;
                if (minCoins == -1 || res < minCoins) {
                    minCoins = res;
                }
            }
        }
        memo.put(amount, minCoins);
        
        return minCoins;
        
        
    }
}
```

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)    {
            return 0;
        }
        int[] dp = new int[nums.length];
        // dp[0] = 1;
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i<nums.length; i++){
            // int maxVal = 0;
            for (int j = 0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            // dp[i] = maxVal + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
```
