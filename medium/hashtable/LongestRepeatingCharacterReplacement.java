package medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int maxLength = 0;
        int start = 0;
        int maxCount = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
            maxCount = Math.max(maxCount, charCountMap.get(currentChar));

            if ((end - start + 1) - maxCount > k) {
                char startChar = s.charAt(start);
                charCountMap.put(startChar, charCountMap.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
