class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            int costDiff = prices[i] - mini;
            profit = Math.max(profit, costDiff);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
}
// Topics -> Arrays, Dynamic Programming, LC-121