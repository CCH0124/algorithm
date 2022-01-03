Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

##### Example 1:
![](https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg)
```
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
```
##### Example 2:
![](https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg)
```
Input: head = [1,1,1,2,3]
Output: [2,3]
``` 

##### Constraints:

- The number of nodes in the list is in the range `[0, 300]`.
- `-100 <= Node.val <= 100`
- The list is guaranteed to be sorted in ascending order.


```java
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        while(head != null) {
            if (head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                temp.next = head.next;
            } else {
                temp = temp.next;
            }
            head = head.next;
        }
        
        return res.next;
    }
}
```