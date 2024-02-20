package hackerrank.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlippingTheMatrix {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2));
        matrix.add(Arrays.asList(3, 4));

        System.out.println(flippingMatrix(matrix));
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> upperLeftQuadrant = new ArrayList<>();
                upperLeftQuadrant.add(matrix.get(i).get(j));
                upperLeftQuadrant.add(matrix.get(i).get(matrix.size() - 1 - j));
                upperLeftQuadrant.add(matrix.get(matrix.size() - 1 - i).get(j));
                upperLeftQuadrant.add(matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j));

                Collections.sort(upperLeftQuadrant);
                sum += upperLeftQuadrant.get(3);
            }
        }

        return sum;
    }
}
