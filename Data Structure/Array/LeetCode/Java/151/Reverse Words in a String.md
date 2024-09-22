**Example 1:**
```
Input: s = "the sky is blue"
Output: "blue is sky the"
```
**Example 2:**
```
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
```
**Example 3:**
```
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
```

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
