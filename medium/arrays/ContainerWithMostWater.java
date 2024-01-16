package medium.arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {2, 1};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentWidth = right - left;
            int currentMinHeight = Math.min(height[left], height[right]);
            int currentArea = currentWidth * currentMinHeight;

            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
