Given an array of non-negative integers nums, you are initially positioned at the **first index** of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

##### Example 1:
```
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```
##### Example 2:
```
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
```
 

##### Constraints:

- `1 <= nums.length <= 104`
- `0 <= nums[i] <= 105`


`nums[0]` 的值表示一開始可以跳到最遠的 `index`，以 `Example 1` 來看 `nums[0]` 值是 2，表示一開始最遠是跳到 `nums[2]`，在這之間會透過一個變數紀錄是否能有跳更遠的值。而無法到達最後的 `index` 可以這麼想，在 `nums[0]` 這個一開始可跳到最遠的值來進行判別，只要無法突破一開始可以跳到最遠的範圍就可以視為無法抵達到最後。
```java
class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            if ( i > max) {
                return false;
            }
            // i 可以表示當前跳了幾格
            // nums[i] 表示從當前的位置還可以往後跳幾格
            max = Math.max(max, nums[i] + i);
        }
        return max >= (nums.length - 1);
    }
}
```