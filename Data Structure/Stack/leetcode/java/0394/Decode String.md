**Example 1:**
```
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
```
**Example 2:**
```
Input: s = "3[a2[c]]"
Output: "accaccacc"
```
**Example 3:**
```
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
```

從範例 2 進行規則上的發想會比較好，因為會有嵌套的 `[]` 問題，再者是數字部分可能是兩位數以上。

```java
// https://leetcode.com/problems/decode-string/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> times = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = 0;
        while(i < len) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                // 如果下一個字元還是數字，因此存在兩位或三位數以上的數字
                while (Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (Character.digit(s.charAt(i), 10));
                    i++;
                }
                times.push(num);
            }  else if (s.charAt(i) == '[') {
                strStack.push(sb);
                sb = new StringBuilder();
                i++;
            }  else if (s.charAt(i) == ']') { 
                int k = times.pop();
                StringBuilder tmp = sb;
                sb = strStack.pop();
                for (int j = 0; j < k; j++) {
                    sb.append(tmp); 
                }
                i++;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
         return sb.toString();
    }
}
```
