Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.


##### Example 1:
```
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```
##### Example 2:
```
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```
##### Example 3:
```
Input: nums = [1]
Output: [[1]]
``` 

##### Constraints:

- `1 <= nums.length <= 6`
- `-10 <= nums[i] <= 10`
- All the integers of nums are unique.


這題思路簡單來說就是列舉所有可能也就是窮舉，因此這邊使用回溯方式來解題。

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), nums);
        return res;
    }
    
    private void backtrace(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        // 只要 temp 中有列舉三個元素，就停止往下
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i<nums.length; i++){
            // 將重複獲取的值排除，因為在題目的條件下，每個數字都唯一所以此判斷方式可行
            if(temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backtrace(res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
```

上面方式對 list 的操作會有效能問題，因此在效能上可在做改進，使用 DFS 概念，如下。

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean [] visit = new boolean[nums.length];
        backtrace(res, new ArrayList<>(), nums, visit);
        return res;
    }
    
    private void backtrace(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean [] visit) {
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i<nums.length; i++){
            if (visit[i]) {
                continue;
            } 
            temp.add(nums[i]);
            visit[i] = true;
            backtrace(res, temp, nums, visit);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
    }
}
```