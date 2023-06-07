package AutumnPlan_2023.June.day_6_7;

// @date 2023/6/7
// @time 11:16
// @author zhangzhi
// @description LeetCode 714. 买卖股票的最佳时机含手续费
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE / 2;
        for(int i = 0; i < n; i++){
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i] - fee);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[n][0];
    }
}
