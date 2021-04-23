Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

整體想法是直接暴力的去匹配，另一種想法是利用 Hash 和字典方式儲存當前的元素和位置，此時再加上 Hash 的搜尋可提高效率。

JAVA

```java
class Solution {
   public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int [] {map.get(target - nums[i]),i};
            }else{
                map.put(nums[i] , i);
            }
        }
        return null;
    }
}
```

```java
class Solution {
   public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int [] { i, j };
                }
            }
        }
        return null;
    }   
}
```

golang

```go
func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    
    for i := 0; i < len(nums); i++ {
        num := target - nums[i];
        if _, ok := m[num]; ok {
            return []int{m[num], i}
        }
        m[nums[i]] = i
    }
    return nil
}
```

```go
func twoSum(nums []int, target int) []int {
    for i:=0; i<len(nums); i++ {
        for j := i+1; j<len(nums); j++ {
            if nums[i] + nums[j] == target {
                return []int{i, j};
            }
        }
    }
    return nil
}
```