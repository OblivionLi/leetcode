package medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums = {1, 0, -1};

        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (map.containsKey(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
