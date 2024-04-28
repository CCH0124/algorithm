```java
# https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder("");
        for (int i = strs.length-1; i >= 0; i--) {
            res.append(strs[i]);
            res.append(" ");
        }

        return res.toString().trim();
    }
}
```
