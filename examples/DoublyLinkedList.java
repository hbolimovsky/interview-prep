public class DoublyLinkedList <T> {

    // TOOD: finish (insert, remove, removeFirst, removeLast, find, get)
    // reference for a good implementation: https://gist.github.com/basavesh/4044475

    public static void main(String[] args) {

        DoublyLinkedList<Integer> ints = new DoublyLinkedList<Integer>();
        ints.add(3);
        ints.add(2);
        ints.add(1);
        ints.printList();

        ints.addFirst(5);
        ints.printList();
    }

    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    private class Node {

        Node prev, next;
        T data;

        public Node(T data, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T t) {
        // empty
        if (head == null && tail == null) {
            Node node = new Node(t, null, null);
            head = node;
            tail = node;
            return;
        }
        // corrupt state
        if (head == null || tail == null) {
            throw new IllegalStateException();
        }

        Node oldHead = head;
        Node newHead = new Node(t, null, oldHead);
        oldHead.prev = newHead;
        head = newHead;
    }

    public void addLast(T t) {
        // empty
        if (head == null && tail == null) {
            Node node = new Node(t, null, null);
            head = node;
            tail = node;
            return;
        }
        // corrupt state
        if (head == null || tail == null) {
            throw new IllegalStateException();
        }

        Node oldTail = tail;
        Node newTail = new Node(t, oldTail, null);
        oldTail.next = newTail;
        tail = newTail;
    }

    public void add(T t) {
        addLast(t);
    }

    public T peakFirst() {

        if (head == null) {
            return null;
        }

        return head.data;
    }

    public T peakLast() {
        
        if (tail == null) {
            return null;
        }

        return tail.data;
    }

    public void printList() {
        System.out.print("null");
        printList(head);
        System.out.println();
    }

    private void printList(Node node) {
        if (node == null) {
            System.out.print("null");
            return;
        }

        System.out.print("<-" + node.data + "->");
        printList(node.next);
    }
}