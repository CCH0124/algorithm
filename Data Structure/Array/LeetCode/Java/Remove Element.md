[No. 27](https://leetcode.com/problems/remove-element/description/)

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int r = 0;
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++ ) {
                if (nums[i] != val) {
                    nums[r] = nums[i];
                    r++;
                }
            }
        }
        
        return r;
    }
}
```
