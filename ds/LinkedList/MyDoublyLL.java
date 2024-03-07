package ds.LinkedList;

public class MyDoublyLL {
    Node head;
    Node tail;
    int size;

    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    // insertion methods
    public void insertAtHead(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            tail.prev = head;
            tail.next = null;

            size++;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtTail(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            insertAtHead(value);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void insertAfter(Node node, int value) {
        if (isEmpty()) {
            insertAtHead(value);
            return;
        }

        Node current = head;
        while (current != null) { // this could check for node instead and the condition would be removed
            if (current.value == node.value) {
                break;
            }

            current = current.next;
        }

        if (current == null) {
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;

        size++;
    }

    public void insertBefore(Node node, int value) {
        if (isEmpty()) {
            insertAtHead(value);
            return;
        }

        Node current = tail;
        while (current != null) { // this could check for node instead and the condition would be removed
            if (current.value == node.value) {
                break;
            }

            current = current.prev;
        }

        if (current == null) {
            return;
        }

        Node newNode = new Node(value);
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        newNode.next = current;

        size++;
    }

    public void insertAtIndex(int index, int value) {
        if (index >= size) {
            return;
        }

        Node current = head;
        while (index-- > 1) {
            current = current.next;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;

        size++;
    }

    // deletion methods
    public void deleteHead() {
        if (isEmpty()) {
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteTail() {
        if (isEmpty()) {
            return;
        }

        if (size == 1) {
            deleteHead();
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteNode(Node node) {
        if (isEmpty()) {
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.value == node.value) {
                break;
            }

            current = current.next;
        }

        if (current == null) {
            return;
        }

        Node temp = current.prev;
        current.prev.next = current.next;
        current.next.prev = temp;
        size--;
    }

    // search methods
    public Node searchForward(int value) {
        if (isEmpty()) {
            return null;
        }

        int index = 0;
        Node current = head;
        while (current != null) {
            index++;
            if (current.value == value) {
                System.out.printf("Found node after %d forward iterations. ", index);
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public Node searchBackward(int value) {
        if (isEmpty()) {
            return null;
        }

        int index = 0;
        Node current = tail;
        while (current != null) {
            index++;
            if (current.value == value) {
                System.out.printf("Found node after %d backward iterations. ", index);
                return current;
            }

            current = current.prev;
        }

        return null;
    }

    public boolean contains(int value) {
        return !isEmpty() && searchForward(value) != null;
    }

    // utility methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reverse() {
        if (size <= 1) {
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
        tail = null;
        size = 0;
    }

    // traverse methods
    public String traverseForward() {
        Node current = head;
        StringBuilder result = new StringBuilder();
        result.append("Forward traversal: ");

        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(" -> ");
            }

            current = current.next;
        }

        return result.toString();
    }

    public String traverseBackward() {
        Node current = tail;
        StringBuilder result = new StringBuilder();
        result.append("Backward traversal: ");

        while (current != null) {
            result.append(current.value);
            if (current.prev != null) {
                result.append(" <- ");
            }

            current = current.prev;
        }

        return result.toString();
    }

    public int getAtIndex(int index) {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        Node current = head;
        while (index-- > 0) {
            current = current.next;
        }

        return current.value;
    }

    // other methods
    public void split(int index) {
        if (isEmpty()) {
            return;
        }

        while (index-- > 0) {
            head = head.next;
        }

        head.prev = null;
    }

    public void merge(MyDoublyLL list) {
        if (isEmpty()) {
            head = list.head;
            return;
        }

        list.head.prev = tail;
        tail.next = list.head;
        tail = list.tail;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "\nList is empty\n";
        }

        return "\nListing: \n" + traverseForward() + " \n" + traverseBackward();
    }
}
