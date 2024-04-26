package easy.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {
        int[][] points = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};

        System.out.println(maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int maxWidth = 0;
        for (int i = 1; i < points.length; i++) {
            int width = points[i][0] - points[i - 1][0];
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}
