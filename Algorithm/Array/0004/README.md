Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return **the median** of the two sorted arrays.

**Example 1:**
```
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
```
**Example 2:**
```
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
```
**Example 3:**
```
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
```
**Example 4:**
```
Input: nums1 = [], nums2 = [1]
Output: 1.00000
```
**Example 5:**
```
Input: nums1 = [2], nums2 = []
Output: 2.00000
```

**Constraints:**

- `nums1.length == m`
- `nums2.length == n`
- `0 <= m <= 1000`
- `0 <= n <= 1000`
- `1 <= m + n <= 2000`
- `-10^6 <= nums1[i], nums2[i] <= 10^6`

**Follow up:** The overall run time complexity should be O(log (m+n)).

因為兩個參數都是以排序的陣列，因此這邊使用兩個 `pointer` 各別指向參數陣列，藉由 `while` 進行比較並將其排序成一個新的陣列。

java

以下時間複雜度為 `O(m+n)`
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] sortArr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while( i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]){
                sortArr[index++] = nums1[i];
                i++;
            } else {
                sortArr[index++] = nums2[j];
                j++;
            }
        }
        // 或許會有其中一個參數已經先排列完，而另一個參數必須繼續迭代完成
        while (j < nums2.length){
            sortArr[index++] = nums2[j];
            j++;
        }
        while  (i < nums1.length){
            sortArr[index++] = nums1[i];
            i++;
        }
        
        if (sortArr.length % 2 == 0) {
            return (sortArr[sortArr.length/2] + sortArr[sortArr.length/2-1])/2.0;
        }
        return sortArr[sortArr.length/2];
    }
}
```

