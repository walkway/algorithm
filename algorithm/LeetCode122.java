/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Best Time to Buy and Sell Stock II
 */
class LeetCode122 {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];

            maxprofit += peak - valley;
        }

        return maxprofit;
    }
}