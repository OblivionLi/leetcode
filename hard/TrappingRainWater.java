package hard;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                trappedWater += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                trappedWater += rightMax - height[right];
                right--;
            }
        }

        return trappedWater;
    }
}
