package medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0, 1, 1, 2};

        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1;
            int last = nums.length - 1;

            while (second < last) {
                int sum = nums[first] + nums[second] + nums[last];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[first], nums[second], nums[last]));

                    while (second < last && nums[second] == nums[second + 1]) {
                        second++;
                    }

                    while (second < last && nums[last] == nums[last - 1]) {
                        last--;
                    }

                    second++;
                    last--;
                } else if (sum < 0) {
                    second++;
                } else {
                    last--;
                }
            }
        }

        return result;
    }
}
