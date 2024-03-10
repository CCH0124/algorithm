```java


    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode prev = null;
        while( curr != null){
            DoublyLinkedListNode temp = curr.next;
            curr.next = prev;
            curr.prev = curr.next;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }

```
