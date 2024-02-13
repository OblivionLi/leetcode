package patterns.twopointers.medium;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));

        int[] nums2 = {-3, 1, 2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums2)));

        int[] nums3 = {-1, 1};
        System.out.println(Arrays.toString(rearrangeArray(nums3)));

        int[] nums4 = {-1, -2, -3, 4, 5, 6};
        System.out.println(Arrays.toString(rearrangeArray(nums4)));

        int[] nums5 = {28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31};
        System.out.println(Arrays.toString(rearrangeArray(nums5)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length, pos = 0, neg = 1;
        int[] arrangedArray = new int[n];

        for (int num : nums) {
            if (num > 0) {
                arrangedArray[pos] = num;
                pos += 2;
            } else {
                arrangedArray[neg] = num;
                neg += 2;
            }
        }

        return arrangedArray;
    }
}
