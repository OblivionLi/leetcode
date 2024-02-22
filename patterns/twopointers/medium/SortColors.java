package patterns.twopointers.medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int redPtr = 0;
        int bluePtr = nums.length - 1;
        int currPtr = 0;

        while (currPtr <= bluePtr) {
            if (nums[currPtr] == 0) {
                swap(nums, currPtr, redPtr);
                redPtr++;
                currPtr++;
            } else if (nums[currPtr] == 2) {
                swap(nums, currPtr, bluePtr);
                bluePtr--;
            } else {
                currPtr++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
