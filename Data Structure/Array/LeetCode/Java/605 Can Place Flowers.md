**Example 1:**
```
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
```
**Example 2:**
```
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
```

```java
// https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int empty = 1;
        for (int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                n = n - (empty-1)/2;
                empty = 0;
            } else {
                empty++;
           } 
            if (n <= 0) {
                return true;
            }
        }
        n = n - (empty/2);

        return n <= 0;
    }
}
```
