package medium.arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 1, 2, 3};
        int target = 3;

        System.out.println(search(nums, target));

//        int[] nums2 = {1, 3};
//        int target2 = 3;
//
//        System.out.println(search(nums2, target2));

//        int[] nums3 = {1};
//        int target3 = 12;
//
//        System.out.println(search(nums3, target3));
//
//        int[] nums3 = {1, 3};
//        int target3 = 0;
//
//        System.out.println(search(nums3, target3));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
