Given the `head` of a linked list, remove the `n^th` node from the end of the list and return its head.

##### Example 1:

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```
##### Example 2:
```
Input: head = [1], n = 1
Output: []
```
##### Example 3:
```
Input: head = [1,2], n = 1
Output: [1]
``` 

##### Constraints:

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`
 

Follow up: Could you do this in one pass?



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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);
        int pos = len - n;
        ListNode res = head;
        if (pos == 0){
            head = head.next;            
            return head;
        }
        while (pos-1 > 0) {
            head = head.next;
            pos--;
        }
        head.next = head.next.next;
        return res;
    }
    
    private int length(ListNode head) {
        int num = 0;
        while(head != null) {
            num++;
            head = head.next;
        }
        
        return num;
    }
}
```


```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    var first = head
    var res = head
    var l = 0
    for first != nil {
        first = first.Next;
        l = l + 1
    }
    var pos = l - n
    if pos == 0 {
        head = head.Next
        return head
    }
    for pos-1 > 0 {
        head = head.Next
        pos = pos - 1
    }
    head.Next = head.Next.Next;
    return res;
}
```