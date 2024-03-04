package patterns.twoheaps.hard;

import java.util.*;

public class SlidingWindowMedian {
    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {2147483647, 2147483647};
//        int k = 3;
        int k = 2;

        System.out.println(Arrays.toString(medianSlidingWindow2(nums, k)));
    }

    public static double[] medianSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = nums.length;
        double[] result = new double[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (maxHeap.size() <= minHeap.size()) {
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }

            if (i >= k) {
                if (!maxHeap.remove(nums[i - k])) {
                    minHeap.remove(nums[i - k]);
                }
            }

            if (i >= k - 1) {
                if (maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = ((double) maxHeap.peek() + minHeap.peek()) / 2;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }
            }
        }

        return result;
    }
}
