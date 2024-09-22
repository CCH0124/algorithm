**Example 1:**
```
Input: s = "hello"
Output: "holle"
```
**Example 2:**
```
Input: s = "leetcode"
Output: "leotcede"
```
```java
# https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            while(start < end && !set.contains(word[start])) {
                start++;
            }

            while(start < end && !set.contains(word[end])) {
                end--;
            }

            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            start++;
            end--;
        }

        return new String(word);
    }
}
```
