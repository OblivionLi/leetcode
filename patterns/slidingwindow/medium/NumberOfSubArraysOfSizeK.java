package patterns.slidingwindow.medium;

public class NumberOfSubArraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        System.out.println(numOfSubarrays(arr, k, threshold));

        int[] arr2 = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k2 = 3;
        int threshold2 = 5;

        System.out.println(numOfSubarrays(arr2, k2, threshold2));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int length = arr.length;
        int count = 0;

        for (int i = 0; i <= length - k; i++) {
            int sum = 0;

            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }

            if (sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }

    //improved solution
    public static int numOfSubarrays2(int[] arr, int k, int threshold) {
        int length = arr.length;
        int count = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if ((double) sum / k >= threshold) {
            count++;
        }

        for (int i = k; i < length; i++) {
            sum += arr[i] - arr[i - k];

            if ((double) sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }
}
