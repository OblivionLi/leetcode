package medium.stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();

        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
                System.out.println("CHECK CHAR: " + ch + " COUNT: " + count);
            } else if (ch == '[') {
                countStack.push(count);
                resultStack.push(currentString);
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                int repeatCount = countStack.pop();
                StringBuilder decodedString = new StringBuilder(resultStack.pop());

                decodedString.append(String.valueOf(currentString).repeat(Math.max(0, repeatCount)));

                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
