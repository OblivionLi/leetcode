package ds.LinkedList;

public class MySinglyLL {
    Node head;
    int size;

    public MySinglyLL() {
        this.head = null;
        size = 0;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    // insertion methods
    public void insertAtHead(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;

            size++;
            return;
        }

        newNode.next = head;
        head = newNode;

        size++;
    }

    public void insertAtTail(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;
    }

    public void insertAfter(Node node, int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = node;
            head.next = newNode;
            size += 2;
            return;
        }

        Node current = head;
        while (current != null) {
            if (current == node) {
                Node temp = current.next;
                current.next = newNode;
                newNode.next = temp;

                size++;
            }

            current = current.next;
        }
    }

    public void insertBefore(Node node, int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            head.next = node;
            size += 2;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (prev != null && prev.next == node) {
                prev.next = newNode;
                prev.next.next = current;

                size++;
            }

            prev = current;
            current = current.next;
        }
    }

    public void insertAtIndex(int index, int value) {
        if (index >= size) {
            return;
        }

        Node current = head;
        Node prev = null;
        while (index-- > 0) {
            prev = current;
            current = current.next;
        }

        if (prev != null) {
            prev.next = new Node(value);
            prev.next.next = current;
            size++;
        }
    }

    // traverse methods
    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("List values: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getAtIndex(int index) {
        if (index >= size) {
            return Integer.MIN_VALUE;
        }

        Node current = head;
        while (index-- > 0) {
            current = current.next;
        }

        return current.value;
    }

    public int getHead() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return head.value;
    }

    public int getTail() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return getAtIndex(size - 1);
    }

    // search methods
    public Node search(int value) { // return type can be int, depends on preferences
        if (isEmpty()) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public boolean contains(int value) {
        return !isEmpty() && search(value) != null;
    }

    // utility methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("Can't reverse an empty list");
            return;
        }

        Node current = head;
        head = null;
        size = 0;

        while (current != null) {
            insertAtHead(current.value);
            current = current.next;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void merge(MySinglyLL list) {
        if (isEmpty()) {
            head = list.head;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = list.head;
        size += list.size();
    }

    public void split(int index) {
        if (isEmpty()) {
            return;
        }

        while (index-- >= 0) {
            head = head.next;
            size--;
        }
    }

    // BONUS FOR CIRCULAR LINKED LISTS
    public int getIndexFromCircularLL(Node node) {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int index = 0;
        Node current = head;

        while (current != node) {
            index++;
            current = current.next;

            if (current == head) {
                return Integer.MIN_VALUE;
            }
        }

        return index % size; // this finds the correct index at the Node provided as the method param
    }
}
