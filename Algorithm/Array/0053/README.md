Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its *sum*.



##### Example 1:
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```
##### Example 2:
```
Input: nums = [1]
Output: 1
```
##### Example 3:
```
Input: nums = [5,4,-1,7,8]
Output: 23
```

##### Constraints:

- `1 <= nums.length <= 3 * 104`
- `-105 <= nums[i] <= 105`
 

**Follow up**: If you have figured out the O(n) solution, try coding another solution using the `divide and conquer approach`, which is more subtle.



這題以題目來看，先記錄第一個數值，接著以迴圈迭代接下來的值，並用當前紀錄值和迭代的值進行比較，看要拿還是不拿。當中會有一個變數負責記錄這過程中最大的值。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int [] res = new int[nums.length];
        res[0] = nums[0];
        int max = res[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < res[i-1] + nums[i]) {
                res[i] = res[i-1] + nums[i];
            } else {
                res[i] = nums[i];
            }
            max = Math.max(max, res[i]);
        }
        // Arrays.stream(res).forEach(System.out::println);
        return max;
    }
}
```