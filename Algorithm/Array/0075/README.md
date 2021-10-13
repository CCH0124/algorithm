Given an array `nums` with `n` objects colored red, white, or blue, sort them [in-place](https://en.wikipedia.org/wiki/In-place_algorithm) so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

##### Example 1:
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```
##### Example 2:
```
Input: nums = [2,0,1]
Output: [0,1,2]
```
##### Example 3:
```
Input: nums = [0]
Output: [0]
```
##### Example 4:
```
Input: nums = [1]
Output: [1]
``` 

##### Constraints:

- `n == nums.length`
- `1 <= n <= 300`
- `nums[i] is 0, 1, or 2.`

**Follow up**: Could you come up with a one-pass algorithm using only constant extra space?

用選擇排序進行實現

```java
class Solution {
    public void sortColors(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
			int index = i; // 初始從 i
			// 找到列表中的最小元素
			for(int j=i+1; j<nums.length; j++) {
				if(nums[j] < nums[index]) { // 搜尋比當前數值小的值 
					index = j;
                }
            }
			// swap
			int temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
		}
    }
}
```