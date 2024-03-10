```java=
/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    Node slow = head;
    Node fast = head;
    while(slow != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == null || fast == null) {
            return false;
        }
        if (slow == fast) {
            return true;
        }
    }
    return false;
}
```
