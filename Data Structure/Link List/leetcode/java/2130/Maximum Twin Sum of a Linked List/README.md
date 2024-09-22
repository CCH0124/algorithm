**Example 1:**

![](https://assets.leetcode.com/uploads/2021/12/03/eg1drawio.png)
```
Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/12/03/eg2drawio.png)

```
Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 
```


```java
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        int size = size(head);
        int mid = size / 2;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        while(start < mid) {
            stack.add(head.val);
            start++;
            head = head.next;
        }
        while(mid < size) {
            max = Math.max(max, stack.pop() + head.val);
            mid++;
            head = head.next;
        }

        return max;
    }

    public int size(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }
}
```
