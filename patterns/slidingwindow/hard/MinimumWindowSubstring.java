package patterns.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "bdab";
        String t = "ab";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, required = targetCount.size();
        int formed = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        int[] result = {-1, 0, 0}; // length, left index, right index

        while (right < s.length()) {
            char ch = s.charAt(right);
            windowCount.put(ch, windowCount.getOrDefault(ch, 0) + 1);

            if (targetCount.containsKey(ch) && windowCount.get(ch).intValue() == targetCount.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                ch = s.charAt(left);

                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                windowCount.put(ch, windowCount.get(ch) - 1);
                if (targetCount.containsKey(ch) && windowCount.get(ch) < targetCount.get(ch)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
