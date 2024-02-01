package hard.arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};

        System.out.println(findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};

        System.out.println(findMedianSortedArrays(nums5, nums6));

        int[] nums7 = {2};
        int[] nums8 = {};

        System.out.println(findMedianSortedArrays(nums7, nums8));

        int[] nums9 = {3};
        int[] nums10 = {-2, -1};

        System.out.println(findMedianSortedArrays(nums9, nums10));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        Arrays.sort(mergedArray);

        if (mergedArray.length == 1) {
            return mergedArray[0];
        }

        if (mergedArray.length % 2 != 0) {
            return mergedArray[mergedArray.length / 2];
        } else {
            return ((double) mergedArray[mergedArray.length / 2 - 1] + (double) mergedArray[mergedArray.length / 2]) / 2;
        }
    }

    // using binary search and divide and conquer
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted!");
    }
}
