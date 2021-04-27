Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.

Each number in `candidates` may only be used once in the combination.

**Note:** The solution set must not contain duplicate combinations.

**Example 1:**
```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
```
**Example 2:**
```
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
```

**Constraints:**
```
- `1 <= candidates.length <= 100`
- `1 <= candidates[i] <= 50`
- `1 <= target <= 30`
```

java

同 0039 方式，只不過多了排序和一個判斷來偵測重複值。還有 level 部分，每次往下傳遞時必須加 1，因為自己只能使用一次。

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int level) {
        if (target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        if (target < 0){
            return;
        }
        
        for(int i=level; i<nums.length; i++){
            if ( i > level && nums[i-1] == nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(res, temp, nums, target-nums[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
    
}
```