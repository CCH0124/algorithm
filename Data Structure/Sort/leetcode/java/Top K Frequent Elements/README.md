```java
# https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/
# https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int index = k - 1;
        while (!pq.isEmpty()) {
            res[index--] = pq.poll().getKey();
        }
        return res;
        
        
    }
}
```
