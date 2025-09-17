class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int hold = -prices[0]; 
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]); // buy or keep holding
            sold = prevHold + prices[i]; // sell today
            rest = Math.max(prevRest, prevSold); // stay idle or come from cooldown
        }

        return Math.max(sold, rest); 
    }
}