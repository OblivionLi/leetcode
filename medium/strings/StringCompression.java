package medium.strings;

import java.util.*;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','a','a','a','a','a','b','b','b','b','b','b','b'};

        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.merge(aChar, 1, Integer::sum);
        }

        chars = new char[map.size() * 2];
        int idx = 0;
        for (var ch : map.entrySet()) {
            System.out.println(ch);
            chars[idx] = ch.getKey();
            idx++;
            chars[idx] = Character.forDigit(ch.getValue(), 10);
            idx++;
        }

        return map.size() * 2;
    }

    public static int compress2(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }

        int writeIndex = 0; // Index to write the compressed characters

        for (int readIndex = 0; readIndex < chars.length; ) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count consecutive occurrences of the current character
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the current character to the compressed array
            chars[writeIndex++] = currentChar;

            // If count is greater than 1, write the count as characters
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[writeIndex++] = digit;
                }
            }
        }

        return writeIndex;
    }
}
