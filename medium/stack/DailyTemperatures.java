package medium.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));

//        int[] temperatures2 = {30, 40, 50, 60};
//        System.out.println(Arrays.toString(dailyTemperatures(temperatures2)));
//
//        int[] temperatures3 = {30, 60, 90};
//        System.out.println(Arrays.toString(dailyTemperatures(temperatures3)));
//
//        int[] temperatures4 = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
//        System.out.println(Arrays.toString(dailyTemperatures(temperatures4)));
//
//        int[] temperatures5 = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
//        System.out.println(Arrays.toString(dailyTemperatures(temperatures5)));
//
//        int[] temperatures6 = {34, 80, 80, 80, 34, 80, 80, 80, 34, 34};
//        System.out.println(Arrays.toString(dailyTemperatures(temperatures6)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        return answer;
    }
}
