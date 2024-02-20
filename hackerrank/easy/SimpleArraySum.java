package hackerrank.easy;

import java.util.List;

public class SimpleArraySum {
    public static void main(String[] args) {
        List<Integer> ar = List.of(1, 2, 3, 4, 10, 11);

        System.out.println(simpleArraySum(ar));
    }

    public static int simpleArraySum(List<Integer> ar) {
        int sum = 0;

        for (Integer num : ar) {
            sum += num;
        }

        return sum;
    }
}
