package AutumnPlan_2023.May.day_5_10;

// @date 2023/5/10
// @time 22:16
// @author zhangzhi
// @description LeetCode 309. 最佳买卖股票时机含冷冻期
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];
        dp[1][1] = Integer.MIN_VALUE / 2;
        for(int i = 0; i < prices.length; i++){
            dp[i + 2][0] = Math.max(dp[i + 1][0], dp[i + 1][1] + prices[i]);
            dp[i + 2][1] = Math.max(dp[i + 1][1], dp[i][0] - prices[i]);
        }
        return dp[prices.length + 1][0];
    }
}
