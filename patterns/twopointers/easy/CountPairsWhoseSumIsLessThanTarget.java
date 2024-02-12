package patterns.twopointers.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget {

    public static void main(String[] args) {
        List<Integer> nums = List.of(-1, 1, 2, 3, 1);
        int target = 2;

        System.out.println(countPairs(nums, target));

        List<Integer> nums2 = List.of(-6,2,5,-2,-7,-1,3);
        int target2 = -2;

        System.out.println(countPairs(nums2, target2));
    }

    public static int countPairs(List<Integer> nums, int target) {
        List<Integer> numsSorted = new ArrayList<>(nums);
        Collections.sort(numsSorted);

        int count = 0;
        int left = 0;
        int right = numsSorted.size() - 1;

        while (left < right) {
            int sum = numsSorted.get(left) + numsSorted.get(right);

            if (sum < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
