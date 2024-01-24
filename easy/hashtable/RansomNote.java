package easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "bg";
        String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";

        System.out.println(canConstruct2(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 1 && magazine.length() == 1 && !ransomNote.equals(magazine)) {
            return false;
        }

        Map<Character, Integer> ransomNoteMap = mapLetters(ransomNote);
        Map<Character, Integer> magazineMap = mapLetters(magazine);

        int countLettersMatched = 0;
        for (var ransomLetter : ransomNoteMap.entrySet()) {
            if (magazineMap.containsKey(ransomLetter.getKey()) &&
                    magazineMap.get(ransomLetter.getKey()) >= ransomLetter.getValue()
            ) {
                countLettersMatched++;
            }
        }

        return countLettersMatched == ransomNoteMap.size();
    }

    public static Map<Character, Integer> mapLetters(String word) {
        Map<Character, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            if (wordMap.containsKey(word.charAt(i))) {
                wordMap.put(word.charAt(i), wordMap.get(word.charAt(i)) + 1);
            } else {
                wordMap.put(word.charAt(i), 1);
            }
        }

        return wordMap;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] alphabets = new int[26];
        for (char c : magazine.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabets[c - 'a'] == 0) {
                return false;
            }
            alphabets[c - 'a']--;
        }

        return true;
    }
}
