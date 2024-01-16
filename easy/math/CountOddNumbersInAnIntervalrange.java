package easy.math;

public class CountOddNumbersInAnIntervalrange {
    public static void main(String[] args) {
        int low = 0;
        int high = 1000000000;

        System.out.println(countOdds(low, high));
    }

    public static int countOdds(int low, int high) {
        if (low < 0 || high < 0)  {
            return -1;
        }

        return (high + 1) / 2 - (low / 2);
    }
}
