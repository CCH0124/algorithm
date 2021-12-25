Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

##### Example 1:
![](https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg)

```
Input: head = [1,2,3,4]
Output: [2,1,4,3]
```

##### Example 2:
```
Input: head = []
Output: []
```

##### Example 3:
```
Input: head = [1]
Output: [1]
```

##### Constraints:
- The number of nodes in the list is in the range `[0, 100]`.
- `0 <= Node.val <= 100`


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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (head != null && head.next != null) {
            ListNode nextStart = head.next.next;
            head.next.next = head;
            temp.next = head.next;
            head.next = nextStart;
            temp = head;
            head = head.next;
        }
        return res.next;
    }
}
```
[參考](https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/24md.html)