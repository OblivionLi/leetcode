package patterns.twopointers.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
        int[] nums = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        int target = -2;

        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }

        return closestSum;
    }
}
