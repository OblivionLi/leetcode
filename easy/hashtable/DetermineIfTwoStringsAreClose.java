package easy.hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String word1 = "aaabbbbccddeeeeefffff";
        String word2 = "aaaaabbcccdddeeeeffff";

        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Set<Character> set1 = getCharacterSet(word1);
        Set<Character> set2 = getCharacterSet(word2);

        if (!set1.equals(set2)) {
            return false;
        }

        Map<Integer, Integer> freqCount1 = getFrequencyCount(word1);
        Map<Integer, Integer> freqCount2 = getFrequencyCount(word2);

        return freqCount1.equals(freqCount2);
    }

    private static Set<Character> getCharacterSet(String word) {
        return word.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

    private static Map<Integer, Integer> getFrequencyCount(String word) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        word.chars().forEach(c -> freqCount.put(c, freqCount.getOrDefault(c, 0) + 1));
        return freqCount;
    }


    public boolean closeStrings2(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            f1[word1.charAt(i) - 'a']++;
            f2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((f1[i] == 0 && f2[i] != 0) || (f1[i] != 0 && f2[i] == 0))
                return false;
        }

        Arrays.sort(f1);
        Arrays.sort(f2);

        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i])
                return false;
        }

        return true;
    }
}
