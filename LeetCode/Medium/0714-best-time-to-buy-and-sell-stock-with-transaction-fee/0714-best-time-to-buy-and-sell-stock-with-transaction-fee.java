class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int notHold = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i] - fee);
        }
        return notHold;
    }
}