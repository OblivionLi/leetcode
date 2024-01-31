package hard.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));

        int[] heights2 = {2, 4};
        System.out.println(largestRectangleArea(heights2));
//
        int[] heights3 = {2};
        System.out.println(largestRectangleArea(heights3));
//
        int[] heights4 = {4, 2};
        System.out.println(largestRectangleArea(heights4));

        int[] heights5 = {0, 2, 0};
        System.out.println(largestRectangleArea(heights5));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
