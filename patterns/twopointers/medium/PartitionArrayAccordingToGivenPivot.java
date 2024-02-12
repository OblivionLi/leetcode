package patterns.twopointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        System.out.println(Arrays.toString(pivotArray(nums, pivot)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] < pivot) {
                swap(nums, current, left);
                left++;
                current++;
            } else if (nums[current] > pivot) {
                swap(nums, current, right);
                right--;
            } else { // nums[current] == pivot
                current++;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
