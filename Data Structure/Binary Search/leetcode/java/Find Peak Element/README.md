題目：https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/801/

https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/

**Example 1:**
```
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
```
**Example 2:**
```
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where
```

```java
# O(n) time，需要遍歷
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] >= nums[1]) {
            return 0;
        }
        if (nums[n - 1] >= nums[n - 2]) {
            return n - 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1])
                return i;
        }
        return nums.length - 1;
    }
}
```


```java
# O(log n)，中 n 是輸入陣列中的元素數量。每一步我們的搜尋都會變成一半。
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l <= r) {
            mid = (l + r)/2;
            if ( (mid == 0 || nums[mid] >= nums[mid - 1]) && 
                (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])  ) {
                return mid;
            }
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        
        return mid;
    }
}
```
