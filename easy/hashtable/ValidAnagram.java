package easy.hashtable;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = getMapFromString(s);
        Map<Character, Integer> map2 = getMapFromString(t);

        return map1.equals(map2);
    }

    private static Map<Character, Integer> getMapFromString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else  {
                map.put(ch, 1);
            }
        }

        return map;
    }
}
