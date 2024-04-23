package easy.arrays;

import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        System.out.println(Arrays.toString(getConcatenation(nums)));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int repetitions = 2;
        int index = 0;

        while (repetitions > 0) {
            for (int num : nums) {
                ans[index++] = num;
            }

            repetitions--;
        }

        // for better runtime but slower memory use system.arraycopy
//        System.arraycopy(nums, 0, ans, 0, nums.length);
//        System.arraycopy(nums, 0, ans, nums.length, nums.length);

        return ans;
    }
}
