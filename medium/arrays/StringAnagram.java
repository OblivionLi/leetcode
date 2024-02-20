package medium.arrays;

import java.util.*;

public class StringAnagram {
    public static void main(String[] args) {
        List<String> dictionary = List.of("hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "ba", "stairs", "raits");
        List<String> query = List.of("a", "nark", "bs", "hack", "stair");

        System.out.println(stringAnagram(dictionary, query));
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : dictionary) {
            String key = getStringKey(word);
            wordCounts.put(key, wordCounts.getOrDefault(key, 0) + 1);
        }

        for (String q : query) {
            String key = getStringKey(q);
            ans.add(wordCounts.getOrDefault(key, 0));
        }

        return ans;
    }

    private static String getStringKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


//    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
//        List<Integer> ans = new ArrayList<>();
//
//        for (String q : query) {
//            int count = 0;
//            for (String d : dictionary) {
//                if (q.length() == 1 && d.length() == 1 && q.equals(d)) {
//                    count++;
//                } else {
//                    if (areAnagrams(q, d)) {
//                        count++;
//                    }
//                }
//            }
//
//            ans.add(count);
//        }
//
//        return ans;
//    }
//
//    private static boolean areAnagrams(String q, String d) {
//        return getStringMap(q).equals(getStringMap(d));
//    }
//
//    private static Map<Character, Integer> getStringMap(String word) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < word.length(); i++) {
//            if (map.containsKey(word.charAt(i))) {
//                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
//            } else {
//                map.put(word.charAt(i), 1);
//            }
//        }
//
//        return map;
//    }
}
