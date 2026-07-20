---
---

Given the `head` of a singly linked list, sort the list using **insertion sort**, and return the sorted list's head.

The steps of the **insertion sort** algorithm:

1. Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
2. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
3. It repeats until no input elements remain.

The following is a graphical example of the **insertion sort** algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

![](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)

Example 1:

![](https://assets.leetcode.com/uploads/2021/03/04/sort1linked-list.jpg)

```
Input: head = [4,2,1,3]
Output: [1,2,3,4]
```

Example 2:

![](https://assets.leetcode.com/uploads/2021/03/04/sort2linked-list.jpg)

```
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
```

**Constraints:**

- The number of nodes in the list is in the range `[1, 5000]`.
- `-5000 <= Node.val <= 5000`

## Solution


**java**

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = head; // curr 是我們在原串列中要拔下來排序的當前節點
        
        while(curr != null) {
            // 先把下一個節點存起來，因為等等 curr.next 會被改掉
            ListNode nextNode = curr.next;
            ListNode prev = dummy;
            // 在已排序串列(dummy -> ...)中找到要插入的位置
            while(prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            // 把 curr 插入到 prev 和 prev.next 之間
            curr.next = prev.next;
            prev.next = curr;
            
            // curr 前進到原串列的下一個節點，繼續下一輪排序
            curr = nextNode;
            
        }
        
        return dummy.next;
    }
}
```

**Complexity**

* **Time complexity:** O(n^2)
    * 在最壞情況下（例如原串列是倒序的 4 -> 3 -> 2 -> 1），每個節點都要從頭遍歷已排序串列，總共需要進行大約 $N^2 / 2$ 次比較。
* **Space complexity:** O(1)
    * 排序過程完全使用現有的串列節點，沒有額外建立新的串列或資料結構，因此額外空間使用為常數。


**golang**


```go
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func insertionSortList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
		return head
	}
    dummy := &ListNode{Val: 0}
	curr := head
    for curr != nil {
        nextNode := curr.Next
        prev := dummy
        for prev.Next != nil && curr.Val > prev.Next.Val {
            prev = prev.Next
        }
        
        curr.Next = prev.Next
        prev.Next = curr
        curr = nextNode
    }
    return dummy.Next
}
```

### 圖解

這張圖呈現了原串列中的 **節點 `2**` 是如何被交換下來，並透過 4 個程式碼步驟，完美塞進 `dummy` 與 `4` 之間的完整過程。


#### 插入排序

```
【 初始狀態 】
 有序串列： (dummy) -> [ 4 ] -> null
             ▲
             |
            prev

 原 串 列：  [ 2 ] -> [ 1 ] -> null
             ▲
             |
            curr
-------------------------------------------------------------------------

【 步驟 1 】 ListNode nextNode = curr.next;
 (先用 nextNode 把後面的節點 1 抓牢，防止迷路)

 有序串列： (dummy) -> [ 4 ] -> null
             ▲
             |
            prev

 原 串 列：  [ 2 ] ------> [ 1 ] -> null
             ▲             ▲
             |             |
            curr        nextNode
-------------------------------------------------------------------------

【 步驟 2 】 curr.next = prev.next;
 (把節點 2 的右手斷開，改去牽 prev 後面的節點 4)

 有序串列： (dummy)    [ 4 ] -> null
             ▲          ▲
             |          |
            prev        |
                        | (新指標)
 原 串 列：  [ 2 ] ------+     [ 1 ] -> null
             ▲                 ▲
             |                 |
            curr            nextNode
-------------------------------------------------------------------------

【 步驟 3 】 prev.next = curr;
 (把 prev (dummy) 原本牽著 4 的手斷開，改去牽節點 2。合體成功！)

 有序串列： (dummy) ──(新指標)──> [ 2 ]
             ▲                    │
             |                    │ (步驟2牽好的)
            prev                  ▼
                                [ 4 ] -> null

                                [ 1 ] -> null
                                  ▲
                                  |
                               nextNode
-------------------------------------------------------------------------

【 步驟 4 】 curr = nextNode;
 (節點 2 安置完畢，curr 前進到下一個節點 1，準備下一輪排序)

 有序串列： (dummy) -> [ 2 ] -> [ 4 ] -> null


 原 串 列：                     [ 1 ] -> null
                                  ▲
                                  |
                                curr (nextNode)

```

---

#### 關鍵動作

該圖可以更清楚程式碼的設計巧思：

1. **步驟 1（護航）**：黃色／右側的 `nextNode` 先站好位置。
2. **步驟 2（接後）**：`[2]` 先找好退路，把它的 `.next` 指向 `[4]`。
3. **步驟 3（連前）**：`dummy` 正式換手，指向 `[2]`。這時整個鏈結就順起來了，變成了 `dummy -> 2 -> 4`。
4. **步驟 4（交棒）**：`curr` 移到 `nextNode` 身上，此時 `dummy` 這一串已經是排好序的完美陣營。
