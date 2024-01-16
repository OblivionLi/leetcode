package easy.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = {4, 2, 1, 1, 2};
        int extraCandies = 1;

        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> kidsWithCandiesTotal = new ArrayList<>(Collections.nCopies(candies.length, true));

        int kidWithTheMostCandies = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (kidWithTheMostCandies < candy) {
                kidWithTheMostCandies = candy;
            }
        }

        for (int j = 0; j < candies.length; j++) {
            if (candies[j] + extraCandies < kidWithTheMostCandies) {
                kidsWithCandiesTotal.set(j, false);
            }
        }

        return kidsWithCandiesTotal;
    }
}
