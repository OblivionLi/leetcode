package easy.arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        moveZeroes2(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[left] != 0) {
                left++;
                right++;
                continue;
            }

            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }

            right++;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes2(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex++] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
