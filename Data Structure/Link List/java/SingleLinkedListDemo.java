// package linkedlist;

import java.util.Objects;
import java.util.Stack;
import java.util.logging.Logger;

import linkedlist.SingleLinkedList.Node;

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "{" + " no='" + no + "'" + ", name='" + name + "'" + ", nickname='" + nickname + "'" + "}";
    }

}

class SingleLinkedList<T> {

    private int size = 0;

    private Node<T> head;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    // private HeroNode head;

    public SingleLinkedList() {
        head = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
       addLast(elem);
    }

    public void addLast(T elem) {
        if (isEmpty()) {
            head = new Node<T>(elem, null);
       } else {
            Node<T> cur = head;
            while ( cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<T>(elem, null);
       }
       size++;
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = new Node<T>(elem, null);
        } else {
            Node<T> node = new Node<T>(elem, head);
            head = node;
        }
        size++;
    }

    public void addAt(int index, T data) throws Exception {
        if (index < 0 || index > this.size) {
            throw new Exception("Illegal Index.");
        }
        if (index == 0) {
            addFirst(data);
            return;
        };
        if (index == size) {
            addLast(data);
            return;
        }
        Node<T> cur = head;
        while (index-1 > 0) {
            cur = cur.next;
            index--;
        }

        Node<T> node = new Node<T>(data, cur.next);
        cur.next = node;
        size++;

    }

    public void display() {
        if (head == null) {
            throw new RuntimeException("is Empty.");
        }
        Node<T> cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
    /**
     * remove first node
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list.");
        }
        T data = head.data;
		head = head.next;
        --size;

        return data;
    }

    /**
     * remove last node
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list.");
        }

        Node<T> cur = head;
        while ( cur.next.next != null) {
            cur = cur.next;
        }
        
        T data = cur.next.data;
        cur.next = null;
        return data;
    }

    /**
     * remove node
     */
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal Index.");
        }
        int i = 0;
        Node<T> cur = head;
        while ( i < index - 1 ) {
            cur = cur.next;
            i++;
        }

        return remove(cur);
    }

    private T remove(Node<T> elem) {
        if (Objects.isNull(elem.next.next)) {
            return removeLast();
        }

        if (elem == head) {
            return removeFirst();
        }
        T data = elem.next.data;
        elem.next = elem.next.next;
        --size;
        return data;
    }

    public int indexOf(Object obj) { 
        int index = 0;
        Node<T> cur = head;
        if (Objects.isNull(obj)) {
            return -1;
        }
        while (cur.next != null && !Objects.equals(obj, cur.data)) {
            cur = cur.next;
            index++;
        }

        return index == 0 ? -1 : index;
    }

}

public class SingleLinkedListDemo {
    private static Logger LOG = Logger.getLogger(SingleLinkedListDemo.class.getName());
    public static void main(String[] args) throws Exception {
        HeroNode hero1 = new HeroNode(1, "itachi", "i");
        HeroNode hero2 = new HeroNode(2, "asdasd", "asd");
        HeroNode hero3 = new HeroNode(3, "vvvvvv", "v");
        HeroNode hero4 = new HeroNode(4, "qqqqq", "q");
        HeroNode hero5 = new HeroNode(5, "madara", "m");

        SingleLinkedList singleLinkedList = new SingleLinkedList<HeroNode>();
        singleLinkedList.add(hero1);
        singleLinkedList.display();
        LOG.info("Insert hero2 to first");
        singleLinkedList.addFirst(hero2);
        singleLinkedList.display();
        LOG.info("Insert hero3 to Last");
        singleLinkedList.addLast(hero3);
        singleLinkedList.display();
        LOG.info("size is: " + singleLinkedList.size());
        LOG.info("Insert hero4 to index 2");
        singleLinkedList.addAt(2, hero4);
        singleLinkedList.display();

        LOG.info("Remove First node");
        var removeFirst = singleLinkedList.removeFirst();
        LOG.info("First node: " + removeFirst.toString());
        singleLinkedList.display();

        LOG.info("Remove Last");
        var removeLast = singleLinkedList.removeLast();
        LOG.info("Remove Last: " + removeLast.toString());
        singleLinkedList.display();

        singleLinkedList.add(hero5);

        LOG.info("Remove at index 2");
        var removeAt = singleLinkedList.removeAt(1);
        LOG.info("Remove at index 2 node: " + removeAt.toString());
        singleLinkedList.display();

        
        int indexOf = singleLinkedList.indexOf(hero5);
        LOG.info("hero5 index is: " + indexOf);
    }
}
