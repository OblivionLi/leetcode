package easy.arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerBed = {1,0,0,0};
        int n = 1;

        System.out.println(canPlaceFlowers(flowerBed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countOfFreeSlotsToPlant = n;
        for (int i = 0; i < flowerbed.length && countOfFreeSlotsToPlant != 0; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    countOfFreeSlotsToPlant--;
                }
            }
        }

        return countOfFreeSlotsToPlant == 0;
    }
}
