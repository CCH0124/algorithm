Given a string `s`, find the length of the **longest substring** without repeating characters.

**Example 1:**
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```
**Example 2:**
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```
**Example 3:**
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
**Example 4:**
```
Input: s = ""
Output: 0
 ```

##### Constraints:

- `0 <= s.length <= 5 * 104`
- `s` consists of English letters, digits, symbols and spaces.

想到不重複就想到 `Set`，接著使用兩個指標，進行遍歷和紀錄。

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!set.contains(c)){
                set.add(c);
                maxLen = Math.max(maxLen, set.size());
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLen;
    }
}
```


以 `pawwkew` 為例 `paw` 會是被紀錄最長的長度，然而接下來是重複的 `w`，我們可以直接刪除第一個變成 `aw`，接著 `awk`；`awke`；`wke`，因為最後是 `w`  因此 `a` 被移除。
