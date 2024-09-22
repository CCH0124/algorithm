**Example 1:**
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```
**Example 2:**
```
Input: height = [1,1]
Output: 1
```

```java
# https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int s = 0;
        int e = height.length - 1;
        while( s < e) {
            area = Math.max(area, Math.min(height[s], height[e]) * (e - s));
            if (height[s] < height[e]) {
                s++;
            }  else {
                e--;
            }
        }

        return area;
    }
}
```
