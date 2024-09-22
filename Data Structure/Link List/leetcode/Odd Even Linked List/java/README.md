**Example**

![](https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg)


```java
# https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/
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
        ListNode evenNode = evenHead;
        ListNode oddNode = head;
        while(evenNode != null && evenNode.next != null) { // 只有雙數索引會存在下下個是 null 的可能，因此須提前判斷
            oddNode.next = oddNode.next.next; 
            oddNode = oddNode.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
        }
         oddNode.next = evenHead;
        return head;
    }
}
```
