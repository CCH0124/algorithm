Given an array nums of `n` integers, return an array of all the unique quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a, b, c, d < n`
- `a`, `b`, `c`, and `d` are **distinct**.
- `nums[a] + nums[b] + nums[c] + nums[d] == target`
You may return the answer in **any order**.

**Example 1:**
```
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```
**Example 2:**
```
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```
 

**Constraints:**

- `1 <= nums.length <= 200`
- `10^9 <= nums[i] <= 10^9`
- `10^9 <= target <= 10^9`

以 3sum 角度看多一層迴圈進行迭代，整題看來會是 `O(n^3)`

java

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.parallelSort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length-3; i++){
            // 避免重複
            if ( i>=1 && nums[i] == nums[i-1]) {
                continue;
            }
            int init = i+1;
            for (int j=i+1; j<nums.length-2; j++){
                // 避免重複
                if ( j>init && nums[j] == nums[j-1]) {
                    continue;
                }    
                int left = j+1;
                int right = nums.length - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if ( sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
                    } else if (target > sum){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return res;
    }
}
```