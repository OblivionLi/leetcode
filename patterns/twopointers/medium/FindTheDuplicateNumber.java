package patterns.twopointers.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate2(nums));

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate2(nums2));
    }

    public static int findDuplicate(int[] nums) {
        int length = nums.length, left = 0, right = 1;
        Arrays.sort(nums);

        while (left < length && right < length) {
            if (nums[left] == nums[right]) {
                return nums[left];
            }

            left++;
            right++;
        }

        return -1;
    }

    // linear runtime
    public static int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
