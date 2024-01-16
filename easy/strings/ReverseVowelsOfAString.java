package easy.strings;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        String[] parts = s.split("");
        int left = 0;
        int right = parts.length - 1;

        while (left < right) {
            if (!isVowel(parts[left])) {
                left++;
            }

            if (!isVowel(parts[right])) {
                right--;
            }

            if (isVowel(parts[left]) && isVowel(parts[right])) {
                String temp = parts[left];
                parts[left] = parts[right];
                parts[right] = temp;
                left++;
                right--;
            }
        }

        return String.join("", parts);
    }

    private static boolean isVowel(String part) {
        String[] vowels = {"a", "e", "i", "o", "u"};

        for (String vowel : vowels) {
            if (part.toLowerCase().equals(vowel)) {
                return true;
            }
        }

        return false;
    }
}
