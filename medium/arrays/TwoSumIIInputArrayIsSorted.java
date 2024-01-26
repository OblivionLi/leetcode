package medium.arrays;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
//        int[] numbers = {5,25,75};
        int[] numbers = {2,3,4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int second = numbers.length - 1;
        int[] indices = new int[2];

        while (first < second) {
            int sum = numbers[first] + numbers[second];

            if (sum == target) {
                indices[0] = first + 1;
                indices[1] = second + 1;
                break;
            } else if (sum < target) {
                first++;
            } else {
                second--;
            }
        }

        return indices;
    }
}
