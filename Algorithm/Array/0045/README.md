Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

##### Example 1:
```
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```
##### Example 2:
```
Input: nums = [2,3,0,1,4]
Output: 2
```

##### Constraints:

- `1 <= nums.length <= 104`
- `0 <= nums[i] <= 1000`

這題是以最少步數抵達至最後一個位置，所以第一個想法就是貪婪盡可能拿到最大值。索引 0 的值是 3 表示要從這三步中找出可跳到最遠的索引，並記錄下他。

```java
class Solution {
    public int jump(int[] nums) {
        int max = nums[0]; // 最大可跳躍數目是第一個元素，因為都要從 0 索引開始跳
        int reach = 0; // 從索引 0 開始，到他能跳躍的最遠數量之間，找出最大的跳躍距離
        int times = 0; // 計算跳了幾次
        for (int i=1; i<nums.length; i++) {
            if (reach < i) {
                times++;
                reach = max;
            }
            max = Math.max(max, nums[i]+i);
        }
        
        return times;
    }
}
```