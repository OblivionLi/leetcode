package hackerrank.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {
    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 3, 4, 3, 2, 1);

        System.out.println(lonelyinteger(a));
    }

    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> n : map.entrySet()) {
            if (n.getValue() > 1) {
                continue;
            }

            return n.getKey();
        }

        return -1;
    }
}
