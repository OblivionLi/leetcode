package patterns.slidingwindow.medium;

import java.util.*;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        String s = "AAAAAAAAAAAAA";
//        String s = "AAAAAAAAAAA";

        System.out.println(findRepeatedDnaSequences(s));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        int sequenceLength = 10;
        if (s.length() < sequenceLength) {
            return new ArrayList<>();
        }

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - sequenceLength; i++) {
            String substring = s.substring(i, i + sequenceLength);
            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }

        return new ArrayList<>(repeated);
    }
}
