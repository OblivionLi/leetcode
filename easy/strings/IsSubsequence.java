package easy.strings;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";

        System.out.println(isSubsequence2(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        String[] sParts = s.split("");
        String[] tParts = t.split("");

        int sIndex = 0;
        int tIndex = 0;
        int countCorrectSequences = 0;

        while (countCorrectSequences != sParts.length && tIndex < tParts.length) {
            if (sParts[sIndex].equals(tParts[tIndex])) {
                countCorrectSequences++;
                sIndex++;
            }
            tIndex++;
        }

        return countCorrectSequences == sParts.length;
    }

    public static boolean isSubsequence2(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int sIndex = 0;
        int tIndex = 0;

        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;
        }

        return false;
    }
}
