Given a collection of numbers, `nums`, that might contain duplicates, return *all possible unique permutations* **in any order**.

 

##### Example 1:
```
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
```
##### Example 2:
```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

##### Constraints:

- `1 <= nums.length <= 8`
- `-10 <= nums[i] <= 10`


思路和 46 題一樣，只不過這題針對了重複的答案進行處理。

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        boolean [] visit = new boolean[nums.length];
        dfs(list, new ArrayList<>(), nums, visit);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> temp, int [] nums, boolean [] visit) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (!visit[i]) {
                if (i > 0 && nums[i] == nums[i-1] && !visit[i-1]) {
                    continue;
                }
                temp.add(nums[i]);
                visit[i] = true;
                dfs(list, temp, nums, visit);
                temp.remove(temp.size() - 1);
                visit[i] = false;
            }
        }
    }
}
```