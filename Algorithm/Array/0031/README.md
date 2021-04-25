Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

**Example 1:**
```
Input: nums = [1,2,3]
Output: [1,3,2]
```
**Example 2:**
```
Input: nums = [3,2,1]
Output: [1,2,3]
```
**Example 3:**
```
Input: nums = [1,1,5]
Output: [1,5,1]
```
**Example 4:**
```
Input: nums = [1]
Output: [1]
```
**Constraints:**

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 100

這題如果以 12615 這數字去找下一個最大數值也就是 12651，可以知道說我們必須從後面往前進行兩兩數值比較。利用第一個迴圈找出後大前小的索引；再利用第二個迴圈從後往前找出比第一個迴圈找出索引還要大的第一個數字。以下是規則，其中 "" 的數字是關鍵

- `126"15" -> 12651`
- `1"23" -> 132`
- `1"15" -> 151`

但是如果是一個遞減且等距數字，則是回到一開數字的初始，如下

- `321 -> 123`
- `4321 -> 123`


java

下面測資 [1,3,2] 失敗，發現頭尾交換的測資都有此問題。同時也發現一個規則，頭尾交換的元素要讓中間元素做排序才會是解答

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length - 2;
        while( j >= 0 && nums[j] >= nums[j+1]) {
            j--;
        }
        int i = nums.length - 1;
        if (j > -1){
            while(i >= 0 && nums[i] <= nums[j]){
                i--;
            }    
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        // j < 0 表示為遞減且等距的數字
        if ( j < 0) {
            Arrays.sort(nums);
        }
        
    }
}
```
修正後如下，但是遇到 `[2,3,1]` 測資會失敗，解答為 `[3,1,2]` 但跑出來結果是 `[3,2,1]`

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length - 2;
        while( j >= 0 && nums[j] >= nums[j+1]) {
            j--;
        }
        int i = nums.length - 1;
        if (j > -1){
            while(i >= 0 && nums[i] <= nums[j]){
                i--;
            }    
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        
        if ( j < 0) {
            Arrays.sort(nums);
        }
        
        if ( j == 0 && i == nums.length-1) {
            Arrays.sort(nums, j+1, nums.length);
        }
        
    }
}
```

如果是 `j < i` 的測資也要用到排序，因此在條件判斷上做了修正。最後正解

```java
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int j = nums.length - 2;
        while( j >= 0 && nums[j] >= nums[j+1]) {
            j--;
        }
        int i = nums.length - 1;
        if (j > -1){
            while(i >= 0 && nums[i] <= nums[j]){
                i--;
            }    
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        
        if ( j == 0 && i == nums.length-1 || j<i) {
            Arrays.sort(nums, j+1, nums.length);
        }
        
    }
}
```