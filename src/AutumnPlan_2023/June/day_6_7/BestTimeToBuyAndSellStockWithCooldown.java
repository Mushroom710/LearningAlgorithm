package AutumnPlan_2023.June.day_6_7;

// @date 2023/6/7
// @time 11:14
// @author zhangzhi
// @description LeetCode 309. 最佳买卖股票时机含冷冻期
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[1][1] = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            dp[i + 2][0] = Math.max(dp[i + 1][0], dp[i + 1][1] + prices[i]);
            dp[i + 2][1] = Math.max(dp[i + 1][1], dp[i][0] - prices[i]);
        }
        return dp[n + 1][0];
    }
}
