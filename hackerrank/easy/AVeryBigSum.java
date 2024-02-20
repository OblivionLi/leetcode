package hackerrank.easy;

import java.util.List;

public class AVeryBigSum {
    public static void main(String[] args) {
        List<Long> ar = List.of(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);

        System.out.println(aVeryBigSum(ar));
    }

    public static long aVeryBigSum(List<Long> ar) {
        Long sum = 0L;

        for (Long num : ar) {
            sum += num;
        }

        return sum;
    }
}
