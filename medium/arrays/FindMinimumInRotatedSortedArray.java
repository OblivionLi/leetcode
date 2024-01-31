package medium.arrays;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums3));

        int[] nums4 = {3, 1, 2};
        System.out.println(findMin(nums4));

        int[] nums5 = {5,1,2,3,4};
        System.out.println(findMin(nums5));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                left++;
            } else {
                return nums[left];
            }
        }

        return nums[left];
    }
}
