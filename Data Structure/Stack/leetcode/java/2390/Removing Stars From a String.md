**Example 1:**
```
Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
```
**Example 2:**
```
Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
```

```java
# https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0;
        while(i < n) {
            if (chars[i] == '*') {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(char e : stack){
            sb.append(e);
        }

        return sb.toString();

    }
}
```
