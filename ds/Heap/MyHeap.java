package ds.Heap;

import java.util.ArrayList;
import java.util.List;

public class MyHeap {
    private final List<Integer> elements;
    private final boolean isMaxHeap;

    public MyHeap(boolean isMaxHeap) {
        elements = new ArrayList<>();
        this.isMaxHeap = isMaxHeap;
    }

    public void insert(int value) {
        elements.add(value);
        heapifyUp(elements.size() - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && !compare(elements.get(parentIndex), elements.get(index))) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private boolean compare(int a, int b) {
        return isMaxHeap ? a < b : a > b;
    }

    private void swap(int i, int j) {
        int temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public int remove() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int removedValue = elements.getFirst();
        elements.set(0, elements.getLast());
        elements.removeLast();

        heapifyDown(0);

        return removedValue;
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < elements.size() && compare(elements.get(leftChild), elements.get(largest)))
            largest = leftChild;
        if (rightChild < elements.size() && compare(elements.get(rightChild), elements.get(largest)))
            largest = rightChild;

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public int peek() {
        return elements.getFirst();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void clear() {
        elements.clear();
    }

    public void printStructure() {
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
            if (2 * i + 1 < elements.size())
                System.out.println("Left Child: " + elements.get(2 * i + 1));
            if (2 * i + 2 < elements.size())
                System.out.println("Right Child: " + elements.get(2 * i + 2));
        }
    }
}