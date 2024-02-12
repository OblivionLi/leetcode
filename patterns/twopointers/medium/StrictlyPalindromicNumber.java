package patterns.twopointers.medium;

public class StrictlyPalindromicNumber {
    public static void main(String[] args) {
        int n = 2;

        System.out.println(isStrictlyPalindromic(n));
    }

    public static boolean isStrictlyPalindromic(int n) {
        return convertNumberToBase(n, n);
    }

    private static boolean convertNumberToBase(int num, int base) {
        if (base == 2) {
            return true;
        }

        StringBuilder result = new StringBuilder();
        int n = num;
        while (n > 0) {
            int remainder = n % base;
            result.insert(0, remainder);
            n /= base;
        }

        int left = 0;
        int right = result.length() - 1;

        while (left < right) {
            if (result.charAt(left) != result.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return convertNumberToBase(num, base - 1);
    }
}
