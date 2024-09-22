![image](https://github.com/CCH0124/algorithm/assets/17800738/a9a4c541-16f8-4779-b822-be60cae0eaa3)**Example**

![](https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg)

```java
# https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if ( l1 != null) {
                sum += l1.val;
            }
            if ( l2 != null) {
                sum += l2.val;
            }
            sum += carry;

            carry = sum / 10;
            temp.next = new ListNode(sum%10);
            temp =  temp.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return res.next;
    }
}
```
