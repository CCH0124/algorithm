```java
# https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 1;
        for (int i=0; i<candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        for(int i=0; i<candies.length; i++) {
            if (candies[i] + extraCandies < max) {
                res.add(false);
            } else {
                res.add(true);
            }
        }

        return res;

    }
}
```
