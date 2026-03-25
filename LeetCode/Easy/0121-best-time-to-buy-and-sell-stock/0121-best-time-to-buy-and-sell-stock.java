class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;
        int minPrice = prices[0];
        int maxProfitt = 0;
        for(int i = 1; i < prices.length; i++){
            int currPrice = prices[i];
            maxProfitt = Math.max(maxProfitt, currPrice - minPrice);
            minPrice = Math.min(minPrice, currPrice);
        }
        return maxProfitt;
    }
}