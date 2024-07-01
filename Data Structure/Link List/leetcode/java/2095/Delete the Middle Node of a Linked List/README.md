```java
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
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
    public ListNode deleteMiddle(ListNode head) {
        int size = len(head);
        int middle = size/2;
        ListNode dummy = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (middle-- > 1) {
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return head;
    }
    public int len(ListNode head)
    {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
```
