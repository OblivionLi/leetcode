package medium.arrays;

public class LongestSubarrayOf1AfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {1,1, 0, 0, 1,1,1,1,1,0};

        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int start = 0;
        int remainingZerosToDelete = 1;
        int maxLength = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] != 1) {
                remainingZerosToDelete--;
                while (remainingZerosToDelete < 0) {
                    if (nums[start] == 0) {
                        remainingZerosToDelete++;
                    }
                    start++;
                }
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength > 0 ? maxLength - 1 : 0;
    }
}
