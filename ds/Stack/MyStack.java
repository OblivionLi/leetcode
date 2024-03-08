package ds.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack {
    Node head;
    Node tail;
    int size;

    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }
    }

    private class StackIterator implements Iterator<Integer> {
        private Node current;

        public StackIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the stack");
            }
            int value = current.value;
            current = current.next;
            return value;
        }
    }

    public void push(int value) {
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

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void pushAll(int[] list) {
        for (int j : list) {
            push(j);
        }
    }

    public void pushIfAbsent(int value) {
        if (isEmpty()) {
            push(value);
            return;
        }

        int index = search(new Node(value));
        if (index == Integer.MIN_VALUE) {
            push(value);
        }
    }

    public Node pop() {
        if (isEmpty()) {
            return null;
        }

        Node poppedNode = tail;
        tail = poppedNode.prev;
        tail.next = null;
        size--;

        return poppedNode;
    }

    public void popUntil(Node node) {
        if (isEmpty()) {
            return;
        }

        int nodeIndex = search(node);
        if (nodeIndex == Integer.MIN_VALUE) {
            return;
        }

        int noOfPops = size - nodeIndex;
        while (noOfPops-- > 1) {
            pop();
        }
    }

    public Node peek() {
        if (isEmpty()) {
            return null;
        }

        return tail;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        int[] arr = toArray();
        clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            push(arr[i]);
        }
    }

    public MyStack copy() {
        MyStack copied = new MyStack();
        copied.head = head;

        return copied;
    }

    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    public int search(Node node) {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        Node current = head;
        int index = -1;
        while (current != null) {
            index++;
            if (current.value == node.value) {
                return index;
            }

            current = current.next;
        }

        return Integer.MIN_VALUE;
    }

    public int[] toArray() {
        int[] arr = new int[size];

        Node current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.value;
            current = current.next;
        }

        return arr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
