package easy.hashtable;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithLargestSum {
    public static void main(String[] args) {
        int[] nums = {-8,-94,-30,-98,-27,62,26};
        int k = 7;

        System.out.println(Arrays.toString(maxSubsequence(nums, k)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
//        if (nums.length == 0) {
//            return new int[]{};
//        }
//
//        if (nums.length < 3 || nums.length == k) {
//            return nums;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - i - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }
//
//        int[] largestSumSubsequence = new int[k];
//        int idx = 0;
//        for (int i = nums.length - k; i < nums.length; i++, idx++) {
//            System.out.println("CHECK i: " + i + " CHECK idx: " + idx + " CHECK num: " + nums[i]);
//            largestSumSubsequence[idx] = nums[i];
//        }
//
//        return largestSumSubsequence;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int num : nums) {
            maxHeap.offer(num);
        }

        int[] largestSumNumbers = new int[k];
        for (int i = 0; i < k; i++) {
            largestSumNumbers[i] = maxHeap.poll();
        }

        return largestSumNumbers;
    }
}
