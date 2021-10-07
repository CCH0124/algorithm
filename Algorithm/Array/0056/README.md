Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

##### Example 1:
```
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```
##### Example 2:
```
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
``` 

##### Constraints:

- `1 <= intervals.length <= 104`
- `intervals[i].length == 2`
- `0 <= starti <= endi <= 104`

從題目來看，我在沒排序之前 `while` 迴圈可以運行，但提交會有些錯誤後來想想要進行排序。因此使用 `sort` 進行排序，概念滿容易理解，`intervals[i][0] <= end` 是個關鍵只要當前的開頭小於或等於上一個的最後元素表示它在上個元素之間，因此我們可以比較當前的最後元素是否比上一個的最後元素大，如果是就表示為它可以跟上個元素合併。
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int n = intervals.length;
        int i = 1;
        while (i < n) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end); 
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end =  intervals[i][1];
            }
            i++;
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
```