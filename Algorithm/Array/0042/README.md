Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

##### Example: 1

![](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

##### Example 2:
```
Input: height = [4,2,0,3,2,5]
Output: 9
```


##### Constraints:

- `n == height.length`
- `0 <= n <= 3 * 104`
- `0 <= height[i] <= 105`



解題的想法是雙指針，會用變數紀錄當前遍歷最大的柱子高度，當只要遇到比當前柱子高度還小的柱子甚至是沒柱子的話，就使用`當前柱子最大高度減去當前的位置`即可知道水位的高度。

```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int res = 0; 
        while (left <= right ) {
            if (height[left] <= height[right]) {
                if (height[left] > maxL){
                    maxL = height[left];
                } else {
                    res += maxL - height[left];
                }
                left++;
            } else {
                if (height[right] > maxR){
                    maxR = height[right];
                } else {
                    res += maxR - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
```

改進

```java
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int res = 0; 
        // 長度小於 3 不可能會有蒐集的可能
        if (height.length < 3) {
            return 0;
        }
        // 檢查是否是遞增
        while (height[left] <= height[left+1]) {
            left++;
            if (left == right){
                return 0;
            }
        }
        // 檢查是否是遞減
        while (height[right] <= height[right-1]) {
            right--;
            if (left == right){
                return 0;
            }
        }
        while (left <= right ) {
            if (height[left] <= height[right]) {
                if (height[left] > maxL){
                    maxL = height[left];
                } else {
                    res += maxL - height[left];
                }
                left++;
            } else {
                if (height[right] > maxR){
                    maxR = height[right];
                } else {
                    res += maxR - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
```