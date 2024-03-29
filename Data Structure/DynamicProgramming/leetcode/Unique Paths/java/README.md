**Example**

![](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)

```
Input: m = 3, n = 7
Output: 28
```

```
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

```java
# https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                
              if (i == 0 || j == 0) {
                dp[i][j] = 1;      
              } else {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
              }
            }
        }       
        return dp[m-1][n-1];
    }
}
```
