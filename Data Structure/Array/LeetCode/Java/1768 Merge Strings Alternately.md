

```java
# https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int s = 0;
        int e = word1.length();
        int w2 = word2.length();
        StringBuilder sb = new StringBuilder("");
        while(s < e) {
            sb.append(word1.charAt(s));
            if (s < w2) {
                sb.append(word2.charAt(s));
            }
            s++;
        }

        if (s < w2) {
            sb.append(word2.substring(s, w2));
        }

        return sb.toString();
    }
}
```
