Given an array of **distinct** integers `candidates` and a `target` integer `target`, return a list of all unique combinations of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order.

The **same** number may be chosen from `candidates` an **unlimited number of times**. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is **guaranteed** that the number of unique combinations that sum up to `target` is less than 150 combinations for the given input.


**Example 1:**
```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
```
**Example 2:**
```
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```
**Example 3:**
```
Input: candidates = [2], target = 1
Output: []
```
**Example 4:**
```
Input: candidates = [1], target = 1
Output: [[1]]
```
**Example 5:**
```
Input: candidates = [1], target = 2
Output: [[1,1]]
```

**Constraints:**

- `1 <= candidates.length <= 30`
- `1 <= candidates[i] <= 200`
- All elements of `candidates` are **distinct**.
- `1 <= target <= 500`

java

使用回溯方式列舉所有可能，但這之中我們可以利用條件判斷省去不必要的判斷。

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {   
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int level) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }    
        if (target < 0){
            return;
        }
        for (int i=level; i<nums.length; i++){
            temp.add(nums[i]);
            backtrack(res, temp, nums, target - nums[i], level++);
            temp.remove(temp.size() - 1);
        }
        
    }
}
```