package hackerrank.easy;

import java.util.List;

public class MiniMaxSum {
    public static void main(String[] args) {
        List<Integer> arr = List.of(7, 69, 2, 221, 8974);
//        List<Integer> arr = List.of(1, 2, 3, 4, 5);

        miniMaxSum(arr);
    }

    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int num : arr) {
            sum += num;
        }

        for (int num : arr) {
            long sumWithoutCurrent = sum - num;
            min = Math.min(min, sumWithoutCurrent);
            max = Math.max(max, sumWithoutCurrent);
        }

        System.out.println(min + " " + max);
    }
}
