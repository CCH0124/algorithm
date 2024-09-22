```java


    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int head1Len = getLen(head1);
        int head2Len = getLen(head2);
        while(head1Len > head2Len){
            head1 = head1.next;
            head1Len--;
        }

        while(head1Len < head2Len){
            head2 = head2.next;
            head2Len--;
        }
    
        while(head1 != null){
            if (head1 == head2){
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return -1;




    }
    static int getLen(SinglyLinkedListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }


```
