**Example 1:**
```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```
**Example 2:**
```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

[Kth Largest Element in an Array](https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/)
[geeksforgeeks | K’th Smallest/Largest Element in Unsorted Array](https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/)
```java
# 使用 Priority Queue 概念
# 透過維護大小
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}
```

```java
# 透過排序
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
```
