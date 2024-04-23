```java
# https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
# https://www.geeksforgeeks.org/program-to-find-greatest-common-divisor-gcd-of-n-strings/
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.length() == 0) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}
```
