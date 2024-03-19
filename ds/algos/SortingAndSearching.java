package ds.algos;

import ds.Heap.MyHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingAndSearching {
    // ~ start of Searching algos
    public boolean linearSearch(int[] arr, int key) {
        if (arr == null) {
            return false;
        }

        for (int j : arr) {
            if (j == key) {
                return true;
            }
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int key) {
        if (arr == null) {
            return false;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public boolean jumpSearch(int[] arr, int key) {
        if (arr == null) {
            return false;
        }

        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));

            if (prev >= n) {
                return false;
            }
        }

        while (arr[prev] < key) {
            prev++;

            if (prev == Math.min(step, n)) {
                return false;
            }
        }

        return arr[prev] == key;
    }

    public boolean interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                return arr[low] == key;
            }

            int pos = low + (((high - low) / (arr[high] - arr[low])) * (key - arr[low]));

            if (arr[pos] == key) {
                return true;
            } else if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return false;
    }

    public boolean exponentialSearch(int[] arr, int key) {
        int n = arr.length;
        if (arr[0] == key) {
            return true;
        }

        int i = 1;
        while (i < n && arr[i] <= key) {
            i = i * 2;
        }

        return binarySearchUtil(arr, i / 2, Math.min(i, n - 1), key);
    }

    // ~ end of Searching algos

    // ~ start of Sorting algos
    public int[] bubbleSort(int[] arr) {
        if (arr == null) {
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public int[] selectionSort(int[] arr) {
        if (arr == null) {
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    public int[] insertionSort(int[] arr) {
        if (arr == null) {
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = temp;
        }

        return arr;
    }

    public int[] quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }

        return arr;
    }

    public int[] mergeSort(int[] arr, int n) {
        if (arr == null || n < 2) {
            return null;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        if (n - mid >= 0) System.arraycopy(arr, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(arr, left, right, mid, n - mid);

        return arr;
    }

    public int[] heapSort(int[] arr) {
        MyHeap heap = new MyHeap(false);

        for (int num : arr) {
            heap.insert(num);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.remove();
        }

        return arr;
    }

    public int[] radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }

        return arr;
    }

    public int[] bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int bucketCount = (max - min) / arr.length + 1;

        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : arr) {
            int bucketIndex = (num - min) / arr.length;
            buckets.get(bucketIndex).add(num);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }

        return arr;
    }
    // ~ end of Sorting algos

    // UTILS
    private boolean binarySearchUtil(int[] arr, int left, int right, int key) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] > key) {
                return binarySearchUtil(arr, left, mid - 1, key);
            } else {
                return binarySearchUtil(arr, mid + 1, right, key);
            }
        }

        return false;
    }

    private void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int j : arr) {
            count[(j / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    private void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < left) {
            arr[k++] = leftArr[i++];
        }

        while (j < right) {
            arr[k++] = rightArr[j++];
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}
