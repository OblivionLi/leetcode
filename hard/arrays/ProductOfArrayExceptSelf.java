package hard.arrays;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(productExceptSelf3(nums));
    }

    // Uses O(n2)
    public static List<Integer> productExceptSelf(int[] nums) {
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int multiply = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }

                multiply *= nums[j];
            }

            answers.add(multiply);
        }

        return answers;
    }

    // Uses O(n2) => second solution
    public static List<Integer> productExceptSelf2(int[] nums) {
        List<Integer> answers = new ArrayList<>();

        int i = 0;
        int j = 0;
        int multiply = 1;
        while (answers.size() != nums.length) {
            if (i == j) {
                j++;
                continue;
            }

            if (j < nums.length) {
                multiply *= nums[j];
                j++;
            } else {
                answers.add(multiply);
                multiply = 1;
                i++;
                j = 0;
            }
        }

        return answers;
    }

    // Uses O(n)
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;

        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        int[] result = new int[n];

        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

    // Uses O(1)
    public static List<Integer> productExceptSelf4(int[] nums) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        int leftProduct = 1;
        int rightProduct = 1;

        for (int num : nums) {
            result.add(leftProduct);
            leftProduct *= num;
        }

        for (int i = n - 1; i >= 0; i--) {
            result.set(i, result.get(i) * rightProduct);
            rightProduct *= nums[i];
        }

        return result;
    }
}
