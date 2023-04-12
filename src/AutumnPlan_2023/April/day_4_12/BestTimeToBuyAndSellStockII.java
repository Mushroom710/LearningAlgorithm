package AutumnPlan_2023.April.day_4_12;

// @date 2023/4/12
// @time 22:06
// @author zhangzhi
// @description LeetCode 122. 买卖股票的最佳时机 II

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // for(int i = 0; i < n; i++){
        //     dp[i][0] = Integer.MIN_VALUE;
        // }
        dp[0][0] = -prices[0];
        for(int i = 1; i < n; i++){
            // 和买卖股票唯一不同的地方，这题可以买卖多次
            // 第i天买入股票，所得现金就是 昨天 不持有股票的所得现金减去 今天的股票价格
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        //System.out.println(dp[n - 1][0] + ":" + dp[n - 1][1]);
        return dp[n - 1][1];
    }
}
