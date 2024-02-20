package hackerrank.easy;

import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {
    public static void main(String[] args) {
        List<Integer> a = List.of(17, 28, 30);
        List<Integer> b = List.of(99, 16, 8);

        System.out.println(compareTriplets(a, b));
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int idx = 0;
        int aPoints = 0;
        int bPoints = 0;

        while (idx < a.size()) {
            if (a.get(idx) > b.get(idx)) {
                aPoints++;
            }

            if (a.get(idx) < b.get(idx)) {
                bPoints++;
            }

            idx++;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(aPoints);
        ans.add(bPoints);

        return ans;
    }
}
