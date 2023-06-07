package AutumnPlan_2023.June.day_6_7;

import java.util.Arrays;

// @date 2023/6/7
// @time 11:15
// @author zhangzhi
// @description LeetCode 123. 买卖股票的最佳时机 III
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n + 1][k + 2][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= k + 1; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE / 2);
            }
        }
        for(int j = 1; j <= k + 1; j++){
            dp[0][j][0] = 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k + 1; j++){
                dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
                dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] - prices[i]);
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[n][k + 1][0];
    }
}
