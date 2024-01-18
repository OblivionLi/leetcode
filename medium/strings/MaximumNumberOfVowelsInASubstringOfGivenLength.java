package medium.strings;

import java.util.Arrays;
import java.util.HashSet;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int maxVowels = 0;
        int currentVowels = 0;

        while (right < s.length()) {
            if (isVowel(s.charAt(right))) {
                currentVowels++;
            }

            if (right - left + 1 == k) {
                maxVowels = Math.max(maxVowels, currentVowels);
                if (isVowel(s.charAt(left))) {
                    currentVowels--;
                }

                left++;
            }

            right++;
        }

        return maxVowels;
    }

    private static boolean isVowel(char letter) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        return vowels.contains(letter);
    }

//    public int maxVowels(String s, int k) {
//        int vc=0;
//        for(int m=0;m<k;m++)
//        {
//            if(isvowel(s.charAt(m)))vc++;
//        }
//        int res = vc;
//        for (int i = 0, j = k; j < s.length(); i++, j++) {
//            if (isvowel(s.charAt(i))) {
//                vc--;
//            }
//            if (isvowel(s.charAt(j))) {
//                vc++;
//            }
//            res = Math.max(res, vc);
//        }
//        return res;
//    }
//    public boolean isvowel(char c){
//        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
//    }
}
