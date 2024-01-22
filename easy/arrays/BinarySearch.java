package easy.arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 5;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
