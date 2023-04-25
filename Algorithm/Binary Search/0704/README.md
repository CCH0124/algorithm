# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Binary Search 演算法。
# Approach
<!-- Describe your approach to solving the problem. -->
由於是一個排序的數列，因此可以透過 Binary Search 演算法實現。
# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
過程都是對折

$$O(log(n))$$

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while ( left <= right) {
            mid = (left+right)/2;
            if (nums[mid] == target) {
                return mid;
            }  else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```