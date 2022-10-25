/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Best Time to Buy and Sell Stock
 */
class Leetcode121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int maxprofit = 0;
        for (int price : prices) {
            maxprofit = Math.max(maxprofit, price - min);
            min = Math.min(min, price);
        }

        return maxprofit;
    }
}