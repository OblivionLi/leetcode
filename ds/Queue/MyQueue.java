package ds.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue {
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
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private class QueueIterator implements Iterator<Integer> {
        private MyQueue.Node current;

        public QueueIterator() {
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

    public void enqueue(int value) {
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

    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node dequeuedNode = head;
        head = dequeuedNode.next;
        dequeuedNode.next = null;
        size--;

        return dequeuedNode;
    }

    public boolean remove(int value) {
        if (isEmpty()) {
            return false;
        }

        Node current = head;
        while (current != null) {
            if (current.value == value) {
                if (current.next == null) {
                    tail = current.prev;
                }

                current.prev.next = current.next;
                current.next = current.prev;

                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node peek() {
        if (isEmpty()) {
            return null;
        }

        return head;
    }

    public int checkTail() {
        return tail.value;
    }

    public boolean contains(int value) {
        if (isEmpty()) {
            return false;
        }

        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void addAll(int[] list) {
        for (int num : list) {
            enqueue(num);
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Iterator<Integer> iterator() {
        return new MyQueue.QueueIterator();
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
}
