package patterns.twopointers.easy;

public class ValidPalindromeII {
    public static void main(String[] args) {
//        String s = "abc";
//        String s = "deeee";
//        String s = "abca";
        String s = "aba";

        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (isPalindrome(s, start + 1, end)) {
                    return true;
                }

                return isPalindrome(s, start, end - 1);
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
