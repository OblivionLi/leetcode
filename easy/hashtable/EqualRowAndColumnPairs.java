package easy.hashtable;

import java.util.*;

public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};

        System.out.println(equalPairs2(grid));
    }

    public static int equalPairs(int[][] grid) {
        int cnt = 0;

        for (int[] nums : grid) {
            for (int j = 0; j < grid.length; ++j) {
                int k = 0;

                for (; k < grid.length; ++k) {
                    if (nums[k] != grid[k][j])
                        break;
                }
                cnt += k == grid.length ? 1 : 0;
            }
        }

        return cnt;
    }

    public static int equalPairs2(int[][] grid) {
        int count = 0;
        int n = grid.length;

        for (int[] value : grid) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(value[j]);
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int[] ints : grid) {
                    colSet.add(ints[j]);
                }

                if (rowSet.equals(colSet)) {
                    count++;
                }
            }
        }

        return count;
    }
}
