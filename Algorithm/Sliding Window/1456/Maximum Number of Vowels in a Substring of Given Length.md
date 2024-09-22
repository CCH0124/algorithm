**Example 1:**
```
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
```
**Example 2:**
```
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
```
**Example 3:**
```
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
```

```java
# https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int baseCount = 0;
        for (int i=0; i<k; i++) {
            if (set.contains(s.charAt(i))) {
                baseCount++;
            }
        }

        int maxCount = baseCount;
        for (int i=k; i<s.length(); i++){
            if (set.contains(s.charAt(i))) {
                baseCount++;
            }
            if (set.contains(s.charAt(i-k))) {
                baseCount--;
            }
            maxCount = Math.max(maxCount, baseCount);
        }

        return maxCount;
    }
}
```
