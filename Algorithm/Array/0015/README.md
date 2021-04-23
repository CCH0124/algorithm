Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

**Example 1:**
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```
**Example 2:**
```
Input: nums = []
Output: []
```
**Example 3:**
```
Input: nums = [0]
Output: []
```
 

**Constraints:**

- `0 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

先做排序，這樣是為了避免重複且比較好處理，接著我們迭代每個數字，並用 `while` 對雙指針方式去計算三個數字是否能夠構成 `0`，因為是排序後，所以當指針的位置數字過大或過小可以輕易地控制。


java

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++){
            // 避免重複
            if ( i >= 1 && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                int target = nums[left] + nums[right];
                if (target == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // 避免重複
                    while ( left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    // 避免重複
                    while ( left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (target > -nums[i]){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
```