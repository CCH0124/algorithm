**Example 1:**
![](https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg)
```
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
```

**Example 2:**
![](https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg)
```
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
```

```java
# https://leetcode.com/problems/odd-even-linked-list/submissions/1313969197/?envType=study-plan-v2&envId=leetcode-75
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        while(  even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}```
