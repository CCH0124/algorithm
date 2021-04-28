Given an unsorted integer array `nums`, find the smallest missing positive integer.
**Example 1:**
```
Input: nums = [1,2,0]
Output: 3
```
**Example 2:**
```
Input: nums = [3,4,-1,1]
Output: 2
```
**Example 3:**
```
Input: nums = [7,8,9,11,12]
Output: 1
``` 

**Constraints:**

- `1 <= nums.length <= 300`
- `-2^31 <= nums[i] <= 2^31 - 1`


java

算是比較直接的解法，使用 `Set` 存放 `nums` 用 `Hash` 方式增加搜尋速度。最後在使用數字 1 到陣列長度跌代並檢查最小遺失的值。

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        for (int i=1; i<=nums.length+1; i++) {
            if(!set.contains(i)) {
                System.out.println(i);
                return i;
            }
        }
        
        return 1;
    }
}
```