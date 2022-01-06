Given the `head` of a singly linked list and two integers `left` and `right` where `left <= right`, reverse the nodes of the list from position `left` to position `right`, and return the reversed list.

##### Example 1:
![](https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg)
```
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
```
##### Example 2:
```
Input: head = [5], left = 1, right = 1
Output: [5]
``` 

##### Constraints:

- The number of nodes in the list is `n`.
- `1 <= n <= 500`
- `-500 <= Node.val <= 500`
- `1 <= left <= right <= n`



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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0, head);
        ListNode t = res;
        int gap = right - left;
        while(left > 1) {
            t = t.next;
            left--;
        }
        ListNode cur = t.next;
        while (gap > 0) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = t.next;
            t.next = temp;
            gap--;
        }
        
        return res.next;
    }
}
```