package hard.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(generateParenthesis(n));

    }

    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        if (n == 1) {
            parenthesis.add("()");
            return parenthesis;
        }



        return null;
    }
}
