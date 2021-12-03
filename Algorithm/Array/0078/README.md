Given an integer array `nums` of **unique** elements, return all possible subsets (the power set).

The solution set **must not** contain duplicate subsets. Return the solution in **any order**.

##### Example 1:

```
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```
##### Example 2:
```
Input: nums = [0]
Output: [[],[0]]
``` 

##### Constraints:

- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- All the numbers of nums are unique.


使用應該算是列舉的概念，初始化時空的 `List` 可以先產生。下面的概念是

```
nums: [1,2,3]
res:[[]]
... 開始遍歷 ...
從 nums 拿 1
從 res 拿 []，並把 [] 加入從 nums 拿的 1，因此變成 [1]，再將其放回 res 中

從 nums 拿 2，此時 res [[], [1]]
從 res 拿 [] 和 [1]，並把 [] 和 [1] 加入從 nums 拿的 2，因此變成 [2], [1,2]，再將其放回 res 中

從 nums 拿 3，此時 res [[], [1], [2], [1,2]]
從 res 拿 []、[1]、[2] 和 [1,2]，並把 []、[1]、[2] 和 [1,2] 加入從 nums 拿的 3，因此變成 [3]、[1,3]、[2,3] 和 [1,2,3]，再將其放回 res 中

nums 遍歷完成，res 為 [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
```

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList<Integer>());
        int currSize = res.size();
        for (int num : nums) {
            List<Integer> subSet = new ArrayList<>();
            for (int i = 0; i < currSize; i++) {
                subSet = new ArrayList<Integer>(res.get(i)){{add(num);}};
                res.add(subSet);
            }
            currSize = res.size();
        }
        
        return res;
    }
}
```