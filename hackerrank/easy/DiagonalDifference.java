package hackerrank.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(11, 2, 4));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(10, 8, -12));

        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftDiagonalSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            leftDiagonalSum += arr.get(i).get(i);
        }

        int rightDiagonalSum = 0;
        int idx = 0;
        for (int j = arr.size() - 1; j >= 0; j--) {
            rightDiagonalSum += arr.get(idx).get(j);
            idx++;
        }

        int max = Math.max(leftDiagonalSum, rightDiagonalSum);
        int min = Math.min(leftDiagonalSum, rightDiagonalSum);
        return max - min;
    }
}
