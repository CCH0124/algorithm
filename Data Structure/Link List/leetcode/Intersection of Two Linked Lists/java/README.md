**Example**

![](https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png)

基本上，將鏈表變成同一常進行比較。

```java
# https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int aSize = length(headA);
        int bSize = length(headB);
        if (aSize > bSize) {
            int skip = aSize - bSize;
            while (skip > 0) {
                headA = headA.next;
                skip--;
            }
        } else if (bSize > aSize){
            int skip = bSize - aSize;
            while (skip > 0) {
                headB = headB.next;
                skip--;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public int length(ListNode head){
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        
        return size;
        
    }
}
```
