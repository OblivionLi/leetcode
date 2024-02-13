package patterns.twopointers.easy;

import java.util.HashMap;

public class NumberOfArithmeticTriplets {
    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;

        System.out.println(arithmeticTriplets(nums, diff));

        int[] nums2 = {4, 5, 6, 7, 8, 9};
        int diff2 = 2;

        System.out.println(arithmeticTriplets(nums2, diff2));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int count = 0;
        int i = 0, j = 1, k = 2;

        while (i < n && j < n && k < n) {
            if (nums[j] - nums[i] < diff) {
                j++;
            } else if (nums[j] - nums[i] > diff) {
                i++;
            } else {
                if (nums[k] - nums[j] < diff) {
                    k++;
                } else if (nums[k] - nums[j] > diff) {
                    j++;
                } else {
                    count++;
                    k++;
                }
            }
        }
        return count;
    }
}
