package AutumnPlan_2023.April.day_4_12;

// @date 2023/4/12
// @time 22:06
// @author zhangzhi
// @description LeetCode 121. 买卖股票的最佳时机

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
        }
        return dp[n - 1][1];
    }
}
