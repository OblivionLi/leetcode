package medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char currentChar = s2.charAt(i);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (windowMap.equals(s1Map)) {
                return true;
            }

            char leftChar = s2.charAt(i - s1.length());
            windowMap.put(leftChar, windowMap.get(leftChar) - 1);
            if (windowMap.get(leftChar) == 0) {
                windowMap.remove(leftChar);
            }

            char rightChar = s2.charAt(i);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
        }

        return windowMap.equals(s1Map);
    }
}
