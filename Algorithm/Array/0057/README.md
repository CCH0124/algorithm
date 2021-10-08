You are given an array of non-overlapping intervals `intervals` where `intervals[i] = [starti, endi]` represent the start and the end of the `i^th` interval and intervals is sorted in ascending order by `start_i`. You are also given an interval `newInterval = [start, end]` that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by `start_i` and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return `intervals` after the insertion.

##### Example 1:
```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```
##### Example 2:
```
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```
##### Example 3:
```
Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
```
##### Example 4:
```
Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
```
##### Example 5:
```
Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]
``` 

##### Constraints:

- `0 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= starti <= endi <= 10^5`
- `intervals` is sorted by `start_i` in ascending order.
- `newInterval.length == 2`
- `0 <= start <= end <= 10^5`



```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int n = intervals.length;
        int i = 0;
        // 如果每個 intervals 的最後一個元素比 newInterval 的 start 還小表示不會重疊
        while(i < n) {
            if (start > intervals[i][1]) {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                break;
            }
            i++;
        }
        // 這邊概念和 Merge Intervals 雷同
        while(i < n) {
            if (intervals[i][0] <= end) { // if true 表示可以合併
                end = Math.max(intervals[i][1], end); 
                if (intervals[i][0] <= start) {
                    start = Math.min(intervals[i][0], start); 
                }
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