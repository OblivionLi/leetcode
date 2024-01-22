package easy.arrays;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0;
        int sc2 = 0;
        int color2 = 0;
        System.out.println(Arrays.deepToString(floodFill(image2, sr2, sc2, color2)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        replaceAllMatching(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private static void replaceAllMatching(int[][] image, int sr, int sc, int initialColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != initialColor) {
            return;
        }

        image[sr][sc] = newColor;

        replaceAllMatching(image, sr - 1, sc, initialColor, newColor); // up
        replaceAllMatching(image, sr + 1, sc, initialColor, newColor); // down
        replaceAllMatching(image, sr, sc - 1, initialColor, newColor); // left
        replaceAllMatching(image, sr, sc + 1, initialColor, newColor); // right
    }
}
