package medium.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2));

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens3));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            switch (token) {
                case "+" -> {
                    int addition1 = stack.pop();
                    int addition2 = stack.pop();

                    stack.push(addition1 + addition2);
                }
                case "-" -> {
                    int subtraction1 = stack.pop();
                    int subtraction2 = stack.pop();

                    stack.push(subtraction2 - subtraction1);
                }
                case "*" -> {
                    int multiplication1 = stack.pop();
                    int multiplication2 = stack.pop();

                    stack.push(multiplication1 * multiplication2);
                }
                case "/" -> {
                    int division1 = stack.pop();
                    int division2 = stack.pop();

                    stack.push(division2 / division1);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
