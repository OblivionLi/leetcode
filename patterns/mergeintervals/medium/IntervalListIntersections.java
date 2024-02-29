package patterns.mergeintervals.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
//
//        int[][] firstList = {{5, 10}};
//        int[][] secondList = {{3, 10}};
//
//        int[][] firstList = {{3, 10}};
//        int[][] secondList = {{5, 10}};

//        int[][] firstList = {{14, 16}};
//        int[][] secondList = {{7, 13}, {16, 20}};

        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }

        List<int[]> list = new ArrayList<>();
        int left = 0;
        int right = 0;

        while (right < secondList.length && left < firstList.length) {
            int start = Math.max(firstList[left][0], secondList[right][0]);
            int end = Math.min(firstList[left][1], secondList[right][1]);

            if (start <= end) {
                list.add(new int[]{start, end});
            }

            if (firstList[left][1] < secondList[right][1]) {
                left++;
            } else {
                right++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
