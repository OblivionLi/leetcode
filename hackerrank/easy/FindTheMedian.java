package hackerrank.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTheMedian {
    public static void main(String[] args) {
        List<Integer> arr = List.of(0, 1, 2, 4, 6, 5, 3);

        System.out.println(findMedian(arr));
    }

    public static int findMedian(List<Integer> arr) {
        List<Integer> mutableList = new ArrayList<>(arr);
        Collections.sort(mutableList);

        int middle = mutableList.size() / 2;

        return mutableList.get(middle);
    }
}
