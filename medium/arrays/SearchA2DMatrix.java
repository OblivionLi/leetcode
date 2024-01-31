package medium.arrays;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));

        int[][] matrix2 = {{1, 3}};
        int target2 = 3;

        System.out.println(searchMatrix(matrix2, target2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (matrix[i][middle] == target) {
                    return true;
                } else if (matrix[i][middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return false;
    }
}
