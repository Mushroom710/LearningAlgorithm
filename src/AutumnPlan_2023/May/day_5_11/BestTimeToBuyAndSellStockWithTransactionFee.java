package AutumnPlan_2023.May.day_5_11;

// @date 2023/5/11
// @time 21:45
// @author zhangzhi
// @description LeetCode 714. 买卖股票的最佳时机含手续费
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE / 2;
        for(int i = 0; i < prices.length; i++){
            dp[i + 1][0] = Math.max(dp[i][1] + prices[i] - fee, dp[i][0]);
            dp[i + 1][1] = Math.max(dp[i][0] - prices[i], dp[i][1]);
        }
        return dp[prices.length][0];
    }
}
