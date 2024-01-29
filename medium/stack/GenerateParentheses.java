package medium.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private static void generateParenthesisHelper(int n, int openCount, int closeCount, StringBuilder current, List<String> result) {
        // Base case: If the length of the current combination is 2n, add it to the result
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Try adding an open parenthesis if the count is less than n
        if (openCount < n) {
            current.append('(');
            generateParenthesisHelper(n, openCount + 1, closeCount, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Try adding a close parenthesis if the count is less than the openCount
        if (closeCount < openCount) {
            current.append(')');
            generateParenthesisHelper(n, openCount, closeCount + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
