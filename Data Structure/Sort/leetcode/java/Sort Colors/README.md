**Example 1:**
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```
**Example 2:**
```
Input: nums = [2,0,1]
Output: [0,1,2]
```
```java
# https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
# [in-place algorithm | geeksforgeeks ] (https://www.geeksforgeeks.org/in-place-algorithm/)
class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i=0; i<=blue; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red++] = temp;
            }  else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i--] = nums[blue];
                nums[blue--] = temp;
            }
        }
    }
    
}
```
