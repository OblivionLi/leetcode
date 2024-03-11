package ds.ArrayList;

import java.util.Arrays;

public class MyArrayList {
    int[] data;
    int dataSize;
    int length;

    public MyArrayList() {
        dataSize = 5;  // can be changed for bigger data
        data = new int[dataSize];
        length = 0;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + Arrays.toString(data) +
                ", dataSize=" + dataSize +
                ", length=" + length +
                '}';
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isIndexValid(int index) {
        return index >= 0 && index < length;
    }

    public int size() {
        return length;
    }

    public void clear() {
        length = 0;
        data = new int[5];
    }

    public void add(int element) {
        if (isEmpty()) {
            data[0] = element;
            length++;
            return;
        }

        if (length < dataSize) {
            data[length] = element;
        } else {
            int newDataSize = dataSize * 2;
            int[] newData = new int[newDataSize];
            System.arraycopy(data, 0, newData, 0, length);

            newData[length] = element;
            data = newData;
            dataSize = newDataSize;
        }

        length++;
    }

    public void set(int index, int element) {
        if (!isIndexValid(index)) {
            return;
        }

        data[index] = element;
    }

    public int get(int index) {
        if (!isIndexValid(index)) {
            return Integer.MIN_VALUE;
        }

        return data[index];
    }

    public void add(int index, int element) {
        if (index < 0 && index >= dataSize) {
            return;
        }

        if (length == dataSize) {
            increaseCapacity();
        }

        System.arraycopy(data, index, data, index + 1, length - index);
        data[index] = element;
        length++;
    }

    public void increaseCapacity() {
        int newCapacity = dataSize * 2;
        data = Arrays.copyOf(data, newCapacity);
        dataSize = newCapacity;
    }

    public int remove(int index) {
        if (index < 0 && index >= dataSize) {
            return Integer.MIN_VALUE;
        }

        int removedElement = data[index];

        System.arraycopy(data, index + 1, data, index, length - index - 1);
        data[length - 1] = 0; // Optional: Set the last element to 0
        length--;

        return removedElement;
    }

    public boolean contains(int element) {
        if (isEmpty()) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (data[i] == element) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(int element) {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        for (int i = 0; i < length; i++) {
            if (data[i] == element) {
                return i;
            }
        }

        return Integer.MIN_VALUE;
    }

    public int lastIndexOf(int element) {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int lastOccurredIndex = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (data[i] == element) {
                lastOccurredIndex = i;
            }
        }

        return lastOccurredIndex;
    }

    public int[] toArray() {
        if (isEmpty()) {
            return data;
        }

        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = data[i];
        }

        return Arrays.copyOfRange(data, 0, length);
    }

    public void addAll(int[] list) {
        for (int i = 0; i < list.length; i++) {
            add(list[i]);
        }
    }

    public int[] reverseArray() {
        if (isEmpty()) {
            return data;
        }

        int[] temp = new int[length];
        for (int i = length - 1, j = 0; i >= 0; i--) {
            temp[j++] = data[i];
        }

        return temp;
    }

    public int[] sortArray() {
        if (isEmpty()) {
            return data;
        }

        int[] sortedArray = toArray();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return sortedArray;
    }
}
