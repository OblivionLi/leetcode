package medium.arrays;

import java.util.Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeros = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeros++;
            }

            end++;

            if (zeros > k) {
                if (nums[start] == 0) {
                    zeros--;
                }

                start++;
            }
        }

        return end - start;
    }
}
