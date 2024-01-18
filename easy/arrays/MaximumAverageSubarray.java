package easy.arrays;

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < 2) {
            return nums[0];
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        for (int j = k; j < nums.length; j++) {
            windowSum = windowSum - nums[j - k] + nums[j];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}
