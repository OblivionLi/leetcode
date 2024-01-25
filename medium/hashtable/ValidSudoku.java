package medium.hashtable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        // Validate rows
        for (int i = 0; i < 9; i++) {
            if (!isValidUnit(board[i])) {
                return false;
            }
        }

        // Validate columns
        for (int j = 0; j < 9; j++) {
            char[] column = new char[9];
            for (int i = 0; i < 9; i++) {
                column[i] = board[i][j];
            }

            if (!isValidUnit(column)) {
                return false;
            }
        }

        // Validate 3x3 sub-boxes
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                char[] subBox = new char[9];
                int index = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        subBox[index++] = board[x][y];
                    }
                }

                if (!isValidUnit(subBox)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidUnit(char[] unit) {
        Set<Character> seen = new HashSet<>();
        for (char digit : unit) {
            if (digit != '.' && !seen.add(digit)) {
                return false;
            }
        }
        return true;
    }
}
