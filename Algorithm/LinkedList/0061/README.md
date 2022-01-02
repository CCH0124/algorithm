Given the `head` of a linked list, rotate the list to the right by `k` places.
##### Example 1:
![](https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg)

```
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
```
##### Example 2:
![](https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg)

```
Input: head = [0,1,2], k = 4
Output: [2,0,1]
```
##### Constraints:

- The number of nodes in the list is in the range `[0, 500]`.
- `-100 <= Node.val <= 100`
- `0 <= k <= 2 * 109`

計算長度，藉由長度拿來跟 `k` 做計算並找到要做變化的節點進行串接。
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int size = len(head);
        if (k % size == 0) {
            return head;
        }
        
        int jumpSize = size - (k % size);
        ListNode temp = head;
         while( jumpSize > 1 ){
            temp = temp.next;
            jumpSize--;
        }
        ListNode start = temp.next;
        temp.next = null;
        
        ListNode startTemp = start;
        while(startTemp.next != null) {
            startTemp = startTemp.next;
        }
        startTemp.next = head;
        
        return start;
        
    }
    private int len(ListNode head){
        int c = 0;
        while(head != null){
            c++;
            head=head.next;
        }
        return c;
    }
}
```