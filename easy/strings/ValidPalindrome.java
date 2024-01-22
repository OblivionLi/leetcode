package easy.strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome2(s));
    }

    public static boolean isPalindrome(String s) {
        String formattedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        StringBuilder reversedString = new StringBuilder();
        for (int i = formattedString.length() - 1; i >= 0; i--) {
            reversedString.append(formattedString.charAt(i));
        }

        return formattedString.contentEquals(reversedString);
    }

    // using two pointers
    public static boolean isPalindrome2(String s) {
        String formattedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = formattedString.length() - 1;

        while (left < right) {
            if (formattedString.charAt(left) != formattedString.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
