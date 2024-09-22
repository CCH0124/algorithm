**Example 1:**
```
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
```
**Example 2:**
```
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
```
**Example 3:**
```
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
```


```java
# https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i=0; i<chars.length; i++){
            if (i + 1 < chars.length && chars[i] == chars[i+1]) {
                count++;
            } else {
                sb.append(chars[i]);
                if (count+1 > 1) {
                    sb.append(count + 1);
                }
                count = 0;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
```
