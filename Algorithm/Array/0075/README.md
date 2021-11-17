Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

##### Example 1:
```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```
##### Example 2:
```
Input: nums = [2,0,1]
Output: [0,1,2]
```
##### Example 3:
```
Input: nums = [0]
Output: [0]
```
##### Example 4:
```
Input: nums = [1]
Output: [1]
```
 

##### Constraints:

- `n == nums.length`
- `1 <= n <= 300`
- `nums[i] is 0, 1, or 2`.
 

**Follow up:** Could you come up with a one-pass algorithm using only constant extra space?

使用三個標識進行記錄，以 `2,0,2,1,1,0` 為例。


```
m
s         e
2,0,2,1,1,0

第一個值為 2 其應該是最後，因此我們與最後一個元素交換，並讓 e 指標減一。變成如下

m
s       e
0,0,2,1,1,2

因為 m 沒有動，剛好第一個值為 0 因此 m、和 s 各遞增一個位置，遞增後下個是 0 同樣再遞增

    m
    s   e
0,0,2,1,1,2

值為 2 其應該是最後，因此我們與 e 位置元素交換，並讓 e 指標減一。變成如下

    m
    s e
0,0,1,1,2,2

上個條件已經排序好，但是因為是 while 迴圈，所以 m 指標同樣會繼續遞增已結束迴圈
```

```java
class Solution {
    public void sortColors(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int m = 0;
        while(m <= e) {
           if (nums[m] == 0) {
               int temp = nums[s];
               nums[s] = nums[m];
               nums[m]  = temp;
               s++;
               m++;
           } else if (nums[m] == 1){
               m++;
           } else {
               int temp = nums[e];
               nums[e] = nums[m];
               nums[m]  = temp;
               e--;
           }
        }
    }
}
```


```go
func sortColors(nums []int)  {
    s := 0
    e := len(nums) - 1
    m := 0
    for m <= e {
        if nums[m] == 0 {
            temp := nums[m]
            nums[m] = nums[s]
            nums[s] = temp
            m = m + 1
            s = s + 1
        } else if nums[m] == 1 {
            m = m + 1
        } else {
            temp := nums[e]
            nums[e] = nums[m]
            nums[m] = temp
            e = e - 1
        }
    }
}
```