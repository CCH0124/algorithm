You are given a **large integer** represented as an integer array digits, where each `digits[i]` is the `i^th` digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

##### Example 1:
```
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
```
##### Example 2:
```
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
```
##### Example 3:
```
Input: digits = [0]
Output: [1]
Explanation: The array represents the integer 0.
Incrementing by one gives 0 + 1 = 1.
Thus, the result should be [1].
```
##### Example 4:
```
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
```

##### Constraints:

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` does not contain any leading `0`'s.


這題很容易，只需注意最後是否有進位。

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int carr = 0;
        for (int i=digits.length-1; i>=0; i--) {
            int num = digits[i];
            if ( i == digits.length-1) {
                num += 1;
            } 
            if (carr > 0) {
                num += carr;
            }
            digits[i] = num%10;
            carr = num/10;
            if (i == digits.length-1 && carr == 0) {
                break;
            }
        }
        
        if (carr == 1) {
            int arr [] = new int[digits.length+1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}
```