package medium.arrays;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left = 1;
        int right = piles[piles.length - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int hoursRequired = calculateHoursRequired(mid, piles);

            if (hoursRequired <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int calculateHoursRequired(int speed, int[] piles) {
        int hours = 0;
        for (int bananas : piles) {
            hours += (bananas + speed - 1) / speed;
        }
        return hours;
    }
}
