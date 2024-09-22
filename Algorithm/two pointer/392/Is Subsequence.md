**Example 1:**
```
Input: s = "abc", t = "ahbgdc"
Output: true
```
**Example 2:**
```
Input: s = "axc", t = "ahbgdc"
Output: false
```

```java
# https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public boolean isSubsequence(String s, String t) {
        int spoint = 0;
        int tpoint = 0;
        if (s.length() == 0) {
            return true;
        }
        while (tpoint < t.length() && spoint < s.length()) {
            if (s.charAt(spoint) == t.charAt(tpoint)) {
                spoint++;
            }
            tpoint++;
        }

        return spoint == s.length();
    }
}
```
