package patterns.slidingwindow.medium;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 2, 4, 3};
//        int target = 7;
//        int[] nums = {1, 4, 4};
//        int target = 4;
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
