package easy.arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {1, 3};

        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
//        if (prices.length == 2) {
//            if (prices[0] > prices[1] || prices[0] == prices[1]) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
//
//        int minPrice = prices[0];
//        int dayOfMinPriceIdx = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if (minPrice > prices[i]) {
//                minPrice = prices[i];
//                dayOfMinPriceIdx = i;
//            }
//        }
//
//        int maxProfit = prices[dayOfMinPriceIdx];
//        int dayWithMaxProfitIdx = 0;
//        for (int j = dayOfMinPriceIdx; j < prices.length; j++) {
//            if (maxProfit < prices[j]) {
//                maxProfit = prices[j];
//                dayWithMaxProfitIdx = j;
//            }
//        }
//
//        if (dayOfMinPriceIdx == prices.length - 1 && prices[dayOfMinPriceIdx] == maxProfit) {
//            return 0;
//        }
//
//        return dayWithMaxProfitIdx + 1;

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            minPrice = Math.min(minPrice, currentPrice);
            int potentialProfit = currentPrice - minPrice;
            maxProfit = Math.max(maxProfit, potentialProfit);
        }

        return maxProfit;
    }
}
