package medium.strings;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "  hello world  ";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");

        int left = 0;
        int right = parts.length - 1;

        while (left < right) {
            String temp = parts[left];
            parts[left] = parts[right];
            parts[right] = temp;

            left++;
            right--;
        }

        return String.join(" ", parts);
    }
}
